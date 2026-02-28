package basic_interface;
import java.util.function.Supplier;
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> s = new Supplier<>() {
            @Override
            public String get() {
                return "Supplier Inner Class";
            }
        };
        System.out.println(s.get());

        // Supplier s1 = () -> "Supplier Lambda";
        // System.out.println(s1.get());
    }
}
