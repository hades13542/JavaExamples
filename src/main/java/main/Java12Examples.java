package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Examples {

    public static void main(String[] args) throws IOException {
        intend();
        transform();
        mismatch();
        teeming();
    }


    static void intend() {
        System.out.println("string".indent(5));
        System.out.println("string".indent(-5));
    }

    static void transform() {
        Function<String, String> reverse = (String value) -> new StringBuilder(value).reverse().toString();
        System.out.println("kajak".transform(reverse));
        System.out.println("biedronka".transform(reverse));
    }

    static void mismatch() throws IOException {
        Path file1 = Path.of("file1");
        Path file2 = Path.of("file2");
        Files.writeString(file1, "TestTestTestTestTestTestTestTest");
        Files.writeString(file2, "TestTestTestTestTestTestTestTset");
        System.out.println(Files.mismatch(file1, file2));
    }

    static void teeming() {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        System.out.println(mean);
    }

    static void newSwitch() {
        //Old way
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                typeOfDay = "Working Day";
                break;
            case SATURDAY:
            case SUNDAY:
                typeOfDay = "Day Off";
        }

        //New way fully introduced in Java 14
        typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };
    }

    static void instanceOf() {
        //old way
        Object obj = "String ofc";
        if (obj instanceof String) {
            String s = (String) obj;
            int len = s.length();
        }
        //new way  fully introduced in Java 14
        if (obj instanceof String s) {
            int len = s.length();
        }
    }
}
