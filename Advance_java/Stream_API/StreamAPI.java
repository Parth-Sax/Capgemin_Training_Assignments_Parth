package streamAPI;

import java.util.*;
import java.util.stream.*;

public class StreamAPI {

    record Product(String name, String category, int price) {}

    public static void main(String[] args) {

        // Immutable vs Mutable list
        List<String> immutableList = Stream.of("red", "green", null, null).toList();
        System.out.println(immutableList);

        System.out.println(" ----------------   ");

        List<String> mutableList =
                Stream.of("red", "green", null, null)
                        .collect(Collectors.toList());

        System.out.println(mutableList);
        mutableList.add("orange");
        mutableList.set(2, "yellow");
        System.out.println(mutableList);

        System.out.println(" ----------------   ");

        // Create product list (IMPORTANT: Use List, not Stream)
        List<Product> products = List.of(
                new Product("bat", "sportsitem", 4000),
                new Product("bells", "sportsitem", 4000),
                new Product("ball", "sportsitem", 2000),
                new Product("mobile", "item", 14000),
                new Product("banana", "fruit", 200),
                new Product("apple", "fruit", 150)
        );

        // 1️⃣ Group by category
        Map<String, List<Product>> categoryMap =
                products.stream()
                        .collect(Collectors.groupingBy(Product::category));

        System.out.println("Grouped by Category:");
        System.out.println(categoryMap);

        // 2️⃣ Sum price by category
        Map<String, Integer> pricing =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::category,
                                Collectors.summingInt(Product::price)
                        ));

        System.out.println("Total Price per Category:");
        System.out.println(pricing);

        // 3️⃣ Average price by category
        Map<String, Double> avg =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::category,
                                Collectors.averagingDouble(Product::price)
                        ));

        System.out.println("Average Price per Category:");
        System.out.println(avg);

        // 4️⃣ Filtering
        List<Product> filtered =
                products.stream()
                        .filter(p -> p.price() > 2500)
                        .collect(Collectors.toList());

        System.out.println("Filtered (>2500):");
        System.out.println(filtered);

        // 5️⃣ Mapping (extract price field)
        List<Integer> extractFields =
                products.stream()
                        .map(Product::price)
                        .toList();

        System.out.println("Extracted Prices:");
        System.out.println(extractFields);

        // 6️⃣ Partitioning
        Map<Boolean, List<Product>> part =
                products.stream()
                        .collect(Collectors.partitioningBy(p -> p.price() > 1000));

        System.out.println("Partitioned (>1000):");
        System.out.println(part);

        // 7️⃣ Summarizing
        IntSummaryStatistics stats =
                products.stream()
                        .collect(Collectors.summarizingInt(Product::price));

        System.out.println("Summary Statistics:");
        System.out.println(stats);
    }
}
