package basic_interface;
import java.util.function.Consumer;
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Consumer InnerClass");
        // --------------------------------------------------
        Consumer<Integer> consumer1 = number -> {
            System.out.println(number);
        };
        consumer1.accept(20);
    }
}
