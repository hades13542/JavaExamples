package main;

public class Java15Examples {
    public static void main(String[] args) {
    }

    static void sealedUsecase() {
        Animal animal = new Cat();
        if (animal instanceof Cat cat) {
            cat.name();
        }
        if (animal instanceof Fish fish) {
            fish.swim();
        }
    }
}

abstract sealed class Animal permits Dog, Cat, Fish {
    String name() {
        return this.getClass().getName();
    }
}

final class Dog extends Animal {}
non-sealed class Cat extends Animal {}
//class Parrot extends Animal {}
sealed class Fish extends Animal permits Goldfish {
    String swim() {
        return "swim";
    }
}
non-sealed class Goldfish extends Fish {}
