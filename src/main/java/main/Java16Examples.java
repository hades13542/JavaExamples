package main;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

public class Java16Examples {
    public static void main(String[] args) {
        //Generalnie to samo co wczesniej, jakieś vector API lepsze daty
        LocalTime date = LocalTime.parse("14:25:08.690791");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B");
        System.out.println(date.format(formatter)); //4 po poludniu

        Set.of(1,23,4,5,66).stream().collect(Collectors.toList()); //old
        Set.of(1,23,4,5,66).stream().toList(); //new

    }
}
