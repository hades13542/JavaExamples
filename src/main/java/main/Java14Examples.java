package main;

public class Java14Examples {
    public static void main(String[] args) {
        var user = new User("welcome", "in", 2020);
        user.name();
//        user.name = ""; not possible, readonly
    }
}

record User(String name, String surname, int age) {
    //Oficially released in 15
}
