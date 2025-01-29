package main;

import java.time.DayOfWeek;
import java.time.chrono.Era;
import java.time.chrono.JapaneseEra;

public class Java13Examples {
    public static void main(String[] args) {
        String TEXT_BLOCK_JSON = """
{
    "name" : "TEST",
    "website" : "https://www.%s.com/"
     fully introduced in Java 14
}
""";

        System.out.println(TEXT_BLOCK_JSON.translateEscapes());
        System.out.println(TEXT_BLOCK_JSON.stripIndent());
        System.out.println(TEXT_BLOCK_JSON.formatted("webpage"));

        switchImproved();
    }

    static void switchImproved() {
        var value = DayOfWeek.MONDAY;
        Integer number = switch (value) {
            case DayOfWeek.MONDAY: yield 1;
            case DayOfWeek.TUESDAY :yield 2;
            case WEDNESDAY, THURSDAY : yield null;
            case DayOfWeek.FRIDAY :yield 5;
            default: yield null;
        };
    }
}
