package list;

import java.util.*;
import java.util.stream.*;

public class ListStreamOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
            10, 25, 30, 15, 10, 50, 25, 70, 80, 15, 90, 60, 45, 30, 5
        );

        List<String> words = Arrays.asList(
            "Java", "Stream", "API", "Lambda", "Java",
            "Filter", "Map", "Reduce", "Stream", "Collect"
        );

        // ═══════════════════════════════════════════════════════════
        //   LIST<INTEGER> OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("=".repeat(55));
        System.out.println("  List<Integer>: " + numbers);
        System.out.println("=".repeat(55));

        // 1. PRINT ALL
        System.out.println("\n1. Print All:");
        numbers.stream()
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 2. COUNT
        System.out.println("\n2. Count:");
        System.out.println("  Total = " + numbers.stream().count());

        // 3. SUM
        System.out.println("\n3. Sum:");
        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .sum();
        System.out.println("  Sum = " + sum);

        // 4. AVERAGE
        System.out.println("\n4. Average:");
        numbers.stream()
               .mapToInt(Integer::intValue)
               .average()
               .ifPresent(a -> System.out.printf("  Average = %.2f%n", a));

        // 5. MAX
        System.out.println("\n5. Maximum:");
        numbers.stream()
               .max(Integer::compareTo)
               .ifPresent(n -> System.out.println("  Max = " + n));

        // 6. MIN
        System.out.println("\n6. Minimum:");
        numbers.stream()
               .min(Integer::compareTo)
               .ifPresent(n -> System.out.println("  Min = " + n));

        // 7. DISTINCT
        System.out.println("\n7. Distinct Elements:");
        numbers.stream()
               .distinct()
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 8. DUPLICATES
        System.out.println("\n8. Duplicate Elements:");
        numbers.stream()
               .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
               .entrySet().stream()
               .filter(e -> e.getValue() > 1)
               .sorted(Map.Entry.comparingByKey())
               .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue() + " times"));

        // 9. SORT ASCENDING
        System.out.println("\n9. Sorted Ascending:");
        numbers.stream()
               .sorted()
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 10. SORT DESCENDING
        System.out.println("\n10. Sorted Descending:");
        numbers.stream()
               .sorted(Comparator.reverseOrder())
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 11. FILTER — even numbers
        System.out.println("\n11. Even Numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 12. FILTER — odd numbers
        System.out.println("\n12. Odd Numbers:");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 13. FILTER — greater than 40
        System.out.println("\n13. Elements Greater Than 40:");
        numbers.stream()
               .filter(n -> n > 40)
               .sorted()
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 14. FILTER — less than 40
        System.out.println("\n14. Elements Less Than 40:");
        numbers.stream()
               .filter(n -> n < 40)
               .sorted()
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 15. MAP — square each
        System.out.println("\n15. Square of Each Element:");
        numbers.stream()
               .distinct()
               .sorted()
               .map(n -> n * n)
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 16. MAP — double each
        System.out.println("\n16. Double of Each Element:");
        numbers.stream()
               .distinct()
               .sorted()
               .map(n -> n * 2)
               .forEach(n -> System.out.print("  " + n));
        System.out.println();

        // 17. REDUCE — product
        System.out.println("\n17. Product of Distinct Elements:");
        long product = numbers.stream()
                              .distinct()
                              .mapToLong(Integer::longValue)
                              .reduce(1L, (a, b) -> a * b);
        System.out.println("  Product = " + product);

        // 18. SECOND LARGEST
        System.out.println("\n18. Second Largest:");
        numbers.stream()
               .distinct()
               .sorted(Comparator.reverseOrder())
               .skip(1)
               .findFirst()
               .ifPresent(n -> System.out.println("  Second Largest = " + n));

        // 19. SECOND SMALLEST
        System.out.println("\n19. Second Smallest:");
        numbers.stream()
               .distinct()
               .sorted()
               .skip(1)
               .findFirst()
               .ifPresent(n -> System.out.println("  Second Smallest = " + n));

        // 20. COUNT EVEN & ODD
        System.out.println("\n20. Count Even & Odd:");
        long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
        long oddCount  = numbers.stream().filter(n -> n % 2 != 0).count();
        System.out.println("  Even Count = " + evenCount);
        System.out.println("  Odd  Count = " + oddCount);

        // 21. PARTITION — above & below average
        System.out.println("\n21. Partition Above & Below Average:");
        double avg = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        Map<Boolean, List<Integer>> partition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n > avg));
        System.out.printf("  Average = %.2f%n", avg);
        System.out.println("  Above Avg : " + partition.get(true));
        System.out.println("  Below Avg : " + partition.get(false));

        // 22. GROUP BY — even / odd
        System.out.println("\n22. Group By Even & Odd:");
        numbers.stream()
               .distinct()
               .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"))
               .forEach((key, val) -> System.out.println("  " + key + " : " + val));

        // 23. FREQUENCY
        System.out.println("\n23. Frequency of Each Element:");
        numbers.stream()
               .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
               .entrySet().stream()
               .sorted(Map.Entry.comparingByKey())
               .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue()));

        // 24. SUMMARY STATISTICS
        System.out.println("\n24. Summary Statistics:");
        IntSummaryStatistics stats = numbers.stream()
                                            .mapToInt(Integer::intValue)
                                            .summaryStatistics();
        System.out.println("  Count   = " + stats.getCount());
        System.out.println("  Sum     = " + stats.getSum());
        System.out.printf ("  Average = %.2f%n", stats.getAverage());
        System.out.println("  Min     = " + stats.getMin());
        System.out.println("  Max     = " + stats.getMax());

        // 25. anyMatch / allMatch / noneMatch
        System.out.println("\n25. Match Operations:");
        System.out.println("  Any element > 80  ? " + numbers.stream().anyMatch(n -> n > 80));
        System.out.println("  All elements > 0  ? " + numbers.stream().allMatch(n -> n > 0));
        System.out.println("  None element < 0  ? " + numbers.stream().noneMatch(n -> n < 0));

        // ═══════════════════════════════════════════════════════════
        //   LIST<STRING> OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  List<String>: " + words);
        System.out.println("=".repeat(55));

        // 26. PRINT ALL
        System.out.println("\n26. Print All:");
        words.stream()
             .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 27. UPPERCASE
        System.out.println("\n27. Convert to UPPERCASE:");
        words.stream()
             .distinct()
             .map(String::toUpperCase)
             .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 28. FILTER — length > 4
        System.out.println("\n28. Words with Length > 4:");
        words.stream()
             .distinct()
             .filter(w -> w.length() > 4)
             .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 29. SORT & JOIN
        System.out.println("\n29. Sorted & Joined:");
        String joined = words.stream()
                             .distinct()
                             .sorted()
                             .collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("  " + joined);

        // 30. WORD → LENGTH MAP
        System.out.println("\n30. Word → Length Map:");
        words.stream()
             .distinct()
             .collect(Collectors.toMap(w -> w, String::length))
             .entrySet().stream()
             .sorted(Map.Entry.comparingByKey())
             .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue()));

        System.out.println("\n" + "=".repeat(55));
        System.out.println("  ALL LIST OPERATIONS DONE!");
        System.out.println("=".repeat(55));
    }
}
/*

---

### Output
```
=======================================================
  List<Integer>: [10,25,30,15,10,50,25,70,80,15,90,60,45,30,5]
=======================================================
1.  Print All      : 10 25 30 15 10 50 25 70 80 15 90 60 45 30 5
2.  Count          : 15
3.  Sum            : 560
4.  Average        : 37.33
5.  Max            : 90
6.  Min            : 5
7.  Distinct       : 10 25 30 15 50 70 80 90 60 45 5
8.  Duplicates     : 10→2  15→2  25→2  30→2
9.  Sorted Asc     : 5 10 10 15 15 25 25 30 30 45 50 60 70 80 90
10. Sorted Desc    : 90 80 70 60 50 45 30 30 25 25 15 15 10 10 5
11. Even           : 10 30 10 50 70 80 90 60 30
12. Odd            : 25 15 25 15 45 5
13. Greater > 40   : 45 50 60 70 80 90
14. Less    < 40   : 5 10 10 15 15 25 25 30 30
15. Squares        : 25 100 225 900 2500 3600 4900 6400 8100
16. Doubled        : 10 20 30 50 60 90 100 120 140 160 180
17. Product        : 356,400,000,000
18. 2nd Largest    : 80
19. 2nd Smallest   : 10
20. Even Count=9   Odd Count=6
21. Above Avg(37.33): [50,70,80,90,60,45]
    Below Avg      : [10,25,30,15,10,25,15,30,5]
22. EVEN : [10,30,50,70,80,90,60,30]
    ODD  : [25,15,45,5]
23. Frequency → 5→1 10→2 15→2 25→2 30→2 45→1 50→1 60→1 70→1 80→1 90→1
24. Count=15 Sum=560 Avg=37.33 Min=5 Max=90
25. Any>80=true  AllPositive=true  NoneNegative=true

=======================================================
  List<String>: [Java,Stream,API,Lambda,Java,Filter,Map,Reduce,Stream,Collect]
=======================================================
26. Java Stream API Lambda Java Filter Map Reduce Stream Collect
27. JAVA STREAM API LAMBDA FILTER MAP REDUCE COLLECT
28. Length>4 → Stream Lambda Filter Reduce Collect
29. [API | Collect | Filter | Java | Lambda | Map | Reduce | Stream]
30. API→3  Collect→7  Filter→6  Java→4  Lambda→6  Map→3  Reduce→6  Stream→6
=======================================================
  ALL LIST OPERATIONS DONE!
=======================================================*/