import java.util.*;
public class SquareRootOfAnInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        int i = 1;
        while(i*i<=n) {
            i++;
        }
        System.out.println(i-1);
    }
}
