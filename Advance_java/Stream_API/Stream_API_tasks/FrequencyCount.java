package streamAPI_task;
import java.util.*;
import java.util.Comparator;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FrequencyCount {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4, 1, 2, 3, 5};

        Map<Integer, Long> frequency =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        ));
        frequency.forEach((key, value) ->
                System.out.println(key + " -> " + value)
        );
    }
}
