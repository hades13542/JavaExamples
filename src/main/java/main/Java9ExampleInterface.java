package main;

public interface Java9ExampleInterface {
    private static String metoda() {
        //Private methods in interface are new from java 9 which can be used to split lengthy default methods
        return "metoda";
    }

    default void check() {
        System.out.println(metoda());
    }
}
