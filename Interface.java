import java.util.Date;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

public class Interface {
    public static void main(String[] args) {
        //RUNNABLE
        Runnable runnable = () -> counter(3);
        new Thread(runnable).start();
        //SUPPLIER Odwołanie do Konstruktora
        Supplier<Random> supplier = Random::new;
        System.out.println(supplier.get().nextInt());
        //CONSUMER Odwołanie do metody
        Consumer<MyBook> consumer = MyBook::printTitle;
        MyBook myBook = new MyBook("Harry Potter");
        consumer.accept(myBook);
        //BICONSUMER
        BiConsumer<Double, Double> biConsumer = (o1, o2) -> System.out.println(o1 + " + " + o2 + " = " + (o1 + o2));
        biConsumer.accept(10.0, 20.0);
        //FUNCTION Odwołanie do metody
        Function<Integer, Integer> function = (integer) -> integer * 2;
        Stream.of(1, 2, 3, 4).map(function).forEach(System.out::print);
        System.out.println();
        //BIFUNCTION
        BiFunction<Integer, Integer, Date> biFunction = (day, month) -> new Date(2022, month, day);
        System.out.println(biFunction.apply(19,3));
        //UNARYOPERATOR
        UnaryOperator<Integer> unaryOperator = Integer::bitCount;
        System.out.println("Count bits: " + unaryOperator.apply(10));
        //BINARYOPERATOR
        BinaryOperator<Double> binaryOperator = (o1, o2) -> {
            if(o1 < o2) {
                return o1;
            } else {
                return o2;
            }
        };
        System.out.println("Get min: " + binaryOperator.apply(10.0, 25.5));
        //PREDICATE
        Predicate<Integer> predicate = (integer) -> integer > 18;
        int age = 19;
        System.out.println("Is Adult: " + predicate.test(age));
        //BIPREDICATE
        BiPredicate<Integer, Integer> biPredicate = (o1, o2) -> o1 < o2;
        System.out.println("Is first lower: " + biPredicate.test(4, 5));
    }


    private static void counter(int seconds) {
        for(int i = 1; i <= seconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            System.out.println(i);
        }
    }
}

