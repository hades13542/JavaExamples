package main;

import org.example.java.modules.TestClass;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Java9Examples  {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println("test");
        new ClassWithInterface().check();
        setOfExample();
    }

    void tryWithResoucesExample() {
        BufferedWriter bufferedWriterOld = new BufferedWriter(null);
        try (bufferedWriterOld) {
            //Code here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Java 9 Style
        try (BufferedWriter bufferedWriter = new BufferedWriter(null)) {
            //Code here
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void setOfExample() {
        //Old way
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        //Old way too
        Set<String> set2 = new HashSet<>();
        set2.add("A");
        set2.add("B");
        set2.add("C");
        //Java 9 way
        Set<String> set3 = Set.of("A", "B", "C");

        System.out.println(set1.equals(set2) == set2.equals(set3));

        List<String> list = List.of("A", "B", "C");
        Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");
    }

    static void optionalStream() {
        List<Optional<Integer>> list = Arrays.asList(Optional.of(1), Optional.of(2), Optional.of(2));

        //Old way
        List<Integer> integers = list.stream().map(Optional::get).toList();
        //New way
        List<Integer> integersStream = list.stream().flatMap(Optional::stream).toList();

        //ifPresentOrElse example (getFirst is a spoiler from 21)
        list.getFirst().ifPresentOrElse(System.out::println
                , () -> System.out.println("Error"));
    }
}

class ClassWithInterface implements Java9ExampleInterface {

}
