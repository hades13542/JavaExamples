package main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

public class Java19Examples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Mozna w javie wolac funkcje w C. na co to komu?
        concurentExampleNew();
        Map<String, String> map = LinkedHashMap.newHashMap(10); //Fixed size initialization
    }

    record Point(int x, int y) { //record not class
    }

    record Total(Point p1, Point p2) {
    }

    static void printSum(Object o) {
        //Old way
        if (o instanceof Point p) {
            int x = p.x();  // get x()
            int y = p.y();  // get y()
            System.out.println(x + y);
        }
        //New way
        if (o instanceof Point(int x,int y)) {  // record pattern
            System.out.println(x + y);
        }
        //Nested patterns
        if (o instanceof Total(Point(int x,int y), Point(int x2,int y2))) {
            System.out.println(x + y + x2 + y2);
        }
    }
    //Preview
    Response concurentExampleOld() throws ExecutionException, InterruptedException {
        try (var executor = Executors.newFixedThreadPool(5)) {
            Future<String> doSomething = executor.submit(Java19Examples::doSomething); //if this fails
            Future<String> doSomethingElse = executor.submit(Java19Examples::doSomethingElse); //this continue 5 min lets say and waste time
            String res1 = doSomething.get(); // in this moment
            String res2 = doSomethingElse.get();
            return new Response(res1, res2); //or this we got info that not everything is ok
        }
    }

    static Response concurentExampleNew() throws ExecutionException, InterruptedException {
        try (var executor = new StructuredTaskScope.ShutdownOnFailure()) { //This mean that if one fail, other too
            StructuredTaskScope.Subtask<String> doSomething = executor.fork(Java19Examples::doSomething);
            StructuredTaskScope.Subtask<String> doSomethingElse = executor.fork(Java19Examples::doSomethingElse);
            executor.join();
            executor.throwIfFailed(IllegalStateException::new);
            return new Response(doSomething.get(), doSomethingElse.get()); //or this we got info that not everything is ok
        }
    }

    static String doSomethingElse() {
        return null;
    }

    static String doSomething() {
        return "";
    }

    record Response(String res1, String res2) {
    }

}
