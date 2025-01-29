package main;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java10Examples {
    public static void main(String[] args) {
        var message = "finallyNoTyping";
        System.out.println(message instanceof String);

//        var element; illegal, need to be initialized
//        var element = null; also cannot be null
//        var array = {1,2,3,4}; array initialiser need to be specified
//        var lambda = (String s) -> s.length(); //lambda needs to be specified as well
//        orElseThrow();
    }

//    public var global = "test"; cannot be public

    static void orElseThrow() {
        Object o = Optional.of(null).orElseThrow(); //throws NoSuchElementException
    }

    static void toUnmodifiable() {
        var integers = Set.of(1, 2, 3, 4, 5, 6);
        integers.stream().collect(Collectors.toUnmodifiableList());
        integers.stream().collect(Collectors.toUnmodifiableSet());
        integers.stream().collect(Collectors.toUnmodifiableMap(Function.identity(), Function.identity()));

        Set.copyOf(integers); //To make copy of elements
    }
}
