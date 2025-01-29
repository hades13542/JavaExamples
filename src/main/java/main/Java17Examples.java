package main;


public class Java17Examples {
    public static void main(String[] args) {
        System.out.println(checkShape(new Triangle()));
    }

    record Human (String name, int age, String profession) {}
    static abstract class Shape {
        int getNumberOfSides() {
            return 0;
        }
    }
    static class Triangle extends Shape {
    }
    static class Circle extends Shape {
    }

    public String checkObject(Object obj) {
        return switch (obj) {
            case Human h -> "Name: %s, age: %s and profession: %s".formatted(h.name(), h.age(), h.profession());
            case Integer c -> "This is a int";
            case String s -> "It is just a string";
            case null -> "It is null";
            default -> "It is an object";
        };
    }

    static public String checkShape(Shape shape) {
        //in java 17 proposal but delivered in java 21 with when keyword
        return switch (shape) {
            case Triangle t when (t.getNumberOfSides() != 3) -> "This is a weird triangle";
            case Circle c when (c.getNumberOfSides() != 0) -> "This is a weird circle";
                default -> "Just a normal shape";
        };
    }
}

