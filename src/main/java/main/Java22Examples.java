package main;

import java.math.BigInteger;
import java.text.ListFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

import static java.util.stream.Gatherers.windowFixed;

public class Java22Examples {

    //Witamy w 2024 :)

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        unusedVariables(List.of(new Order(1), new Order(2)));

        //Locale-Dependent List Patterns
        List<String> list = List.of("One", "Two", "Three");
        ListFormat formatter = ListFormat.getInstance(Locale.US, ListFormat.Type.STANDARD, ListFormat.Style.FULL);
        System.out.println(formatter.format(list));

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> lists = integers.stream()
                .gather(windowFixed(3))
                .toList();
        System.out.println(lists);

        //Structured concurency
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
            scope.fork(Java19Examples::doSomething);
            scope.fork(Java19Examples::doSomethingElse);
            scope.join();
            String result = (String) scope.result(); //Its a race, first one will be here
            System.out.println(result);
        }
    }

    record Order(int i) {

    }

    private static int unusedVariables(Iterable<Order> orders) {
        int total = 0;
        for (Order order : orders) {    // order is unused
            total++;

        }

        for (Order _ : orders) {    // order is unused new way
            total++;

        }
        return total;
    }

    class MyInteger extends BigInteger {
        MyInteger(String value) {
            super(value);
            if (value.isEmpty()) {
                throw new RuntimeException();
            }
//            super(value); //Not possible in old java
        }
    }


}
