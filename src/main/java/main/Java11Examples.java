package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Java11Examples {
    public static void main(String[] args) {
        newStringMethods();
        not();
        pattern();
    }

    static void newStringMethods() {
        var testString = "       testString testString2 testString3         ";
        System.out.println(testString.strip()); // testString testString2 testString3
        System.out.println(" ".isBlank());
        "a\na\na\na\na\n".lines().forEach(System.out::println);
        System.out.println(testString.stripLeading());
        System.out.println(testString.stripTrailing());
        System.out.println("kermit ".repeat(10));
    }

    static void collectionToArray() {
        var array = List.of(1, 2, 3, 4, 5).toArray();
        var array2 = Set.of(1, 2, 3, 4, 5).toArray();
    }

    static void not() {
        var result = Stream.of("Java", "\n \n", "Kotlin", " ")
                .filter(Predicate.not(String::isBlank))
                .toList();
        System.out.println(result);
    }

    static void writeReadString() {
        try {
            Path demo = Files.createTempFile(Path.of("."), "demo", ".txt");
            Files.writeString(demo, "Text");
            String text = Files.readString(demo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void pattern() {

        var pattern = Pattern.compile(".*");
        List.of("A","B","C").stream()
                .filter(e -> pattern.matcher(e).find())
                .filter(pattern.asPredicate()) //find
                .filter(e -> pattern.matcher(e).matches())
                .filter(pattern.asMatchPredicate()) //match
                        .forEach(System.out::println);
//        System.out.println(pattern.asMatchPredicate());
    }
}
