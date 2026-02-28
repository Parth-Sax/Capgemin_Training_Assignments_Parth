package basic_interface;
import java.util.function.Function;
public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> function = new Function<>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        System.out.println(function.apply(12));
        // -----------------------------------------------
        Function<Integer, Integer> function1 = number -> number * number;
        System.out.println(function1.apply(11));
    }
}
