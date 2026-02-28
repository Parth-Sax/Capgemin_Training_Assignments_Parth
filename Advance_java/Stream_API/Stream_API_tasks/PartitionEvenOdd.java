package streamAPI_task;
import java.util.*;
import java.util.stream.*;
public class PartitionEvenOdd {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,1,4};
        // Convert array to Stream and partition
        Map<Boolean, List<Integer>> result =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Print Even numbers
        System.out.println("Even Numbers: " + result.get(true));

        // Print Odd numbers
        System.out.println("Odd Numbers: " + result.get(false));
    }
}
