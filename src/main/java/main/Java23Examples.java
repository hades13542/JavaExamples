package main;

//import module java.base;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Paths;

public class Java23Examples {

    /**
     * # Example
     *
     * This is a **Markdown** comment.
     *
     * - Item 1
     * - Item 2
     */
    public static void main(String[] args) throws IOException {
        switchWithPrimitives(1);
        updatedClassApi();
        // A vectory dalej nie doczekaly sie swojego releasu :)
    }

    private static void switchWithPrimitives(int x) {
        switch (x) {
//            case int i -> System.out.println("It's an integer: " + i);
//            case double d -> System.out.println("It's a double: " + d);
        }
    }

    private static void updatedClassApi() throws IOException {
        ClassModel model = ClassFile.of().parse(Paths.get("out/production/classes/main/Java19Examples.class"));
        for (MethodModel method : model.methods()) {
            System.out.println(method.methodName());
        }
    }
}
