package Java8API;

import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String args[]) {
        MyFunctionalInterface myfunc = () -> System.out.println("Hello, this is a functional interface!");
        myfunc.print();

        // Predicate
        BiPredicate<String, String> result = (a, b) -> a.equals(b);
        System.out.println("Are the strings equal? " + result.test("Hello", "Hello"));
        System.out.println("Are the strings equal? " + result.test("Hello", "Helo"));

        // Supplier
        Supplier<String> supplier = () -> "Hello, this is a supplier!";
        System.out.println("Supplier output: " + supplier.get());


        // BiFunction
        BiFunction<Integer, Integer, Integer> add = (a,b)-> a+b;
        BiFunction<Integer, Integer, Integer> sub = (a,b)->a-b;
        BiFunction<Integer,Integer, Integer> mul = (a, b) -> a*b;

        // Consumer
        Consumer<Integer> consumer = (a) -> System.out.println("Consumed value: " + a);
        consumer.accept(10);

        System.out.println("Addition: " + add.apply(5, 3));
        System.out.println("Subtraction: " + sub.apply(5, 3));
        System.out.println("Multiplication: " + mul.apply(5, 3));
        MathOperation m = (a,b) -> a+b;
        System.out.println("Using MathOperation interface: " + m.calculate(10, 5));

        // UnaryOperator
        UnaryOperator<Integer> square = (a) -> a * a;
        System.out.println("Square of 5: " + square.apply(5));

        // BinaryOperator
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiplication of 5 and 3: " + multiply.apply(5, 3));

        // Using print method with a Supplier
        print ("This is excellent", () -> "This is a message from the supplier!");

    }

    public static void print (String message, Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void print();
    }

    @FunctionalInterface
    interface MathOperation {
        int calculate(int a, int b);
    }
}
