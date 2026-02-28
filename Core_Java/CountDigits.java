import java.util.*;
public class CountDigits {
    public static int countDigits(int number) {

        int count = 0;

        // Handle negative numbers
        if (number < 0) {
            number = -number;
        }

        // Special case: 0 has 1 digit
        if (number == 0) {
            return 1;
        }

        while (number > 0) {
            number = number / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int num = 12345;

        int digits = countDigits(num);

        System.out.println("Number of digits: " + digits);
    }
}
