package claude.StreamOperation;

import java.util.*;
import java.util.stream.*;

public class ArrayStreamOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // INPUT — Array Size
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        // INPUT — Array Elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("  Element[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  Input Array: " + Arrays.toString(arr));
        System.out.println("=".repeat(50));

        // 1. PRINT ALL ELEMENTS
        System.out.println("\n1. All Elements:");
        Arrays.stream(arr)
              .forEach(e -> System.out.print("   " + e));
        System.out.println();

        // 2. SUM
        System.out.println("\n2. Sum:");
        int sum = Arrays.stream(arr).sum();
        System.out.println("   Sum = " + sum);

        // 3. AVERAGE
        System.out.println("\n3. Average:");
        OptionalDouble avg = Arrays.stream(arr).average();
        avg.ifPresent(a -> System.out.printf("   Average = %.2f%n", a));

        // 4. MAX
        System.out.println("\n4. Maximum:");
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("   Max = " + max);

        // 5. MIN
        System.out.println("\n5. Minimum:");
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("   Min = " + min);

        // 6. COUNT
        System.out.println("\n6. Count:");
        long count = Arrays.stream(arr).count();
        System.out.println("   Total Elements = " + count);

        // 7. SORT ASCENDING
        System.out.println("\n7. Sorted Ascending:");
        int[] sortedAsc = Arrays.stream(arr).sorted().toArray();
        System.out.println("   " + Arrays.toString(sortedAsc));

        // 8. SORT DESCENDING
        System.out.println("\n8. Sorted Descending:");
        int[] sortedDesc = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("   " + Arrays.toString(sortedDesc));

        // 9. FILTER EVEN NUMBERS
        System.out.println("\n9. Even Numbers:");
        int[] evens = Arrays.stream(arr).filter(e -> e % 2 == 0).toArray();
        System.out.println("   " + Arrays.toString(evens));

        // 10. FILTER ODD NUMBERS
        System.out.println("\n10. Odd Numbers:");
        int[] odds = Arrays.stream(arr).filter(e -> e % 2 != 0).toArray();
        System.out.println("   " + Arrays.toString(odds));

        // 11. FILTER GREATER THAN AVERAGE
        System.out.println("\n11. Elements Greater Than Average:");
        double average = avg.getAsDouble();
        int[] aboveAvg = Arrays.stream(arr)
                               .filter(e -> e > average)
                               .toArray();
        System.out.printf("   Average = %.2f%n", average);
        System.out.println("   Above Avg = " + Arrays.toString(aboveAvg));

        // 12. SQUARE OF EACH ELEMENT
        System.out.println("\n12. Square of Each Element:");
        int[] squares = Arrays.stream(arr).map(e -> e * e).toArray();
        System.out.println("   " + Arrays.toString(squares));

        // 13. CUBE OF EACH ELEMENT
        System.out.println("\n13. Cube of Each Element:");
        int[] cubes = Arrays.stream(arr).map(e -> e * e * e).toArray();
        System.out.println("   " + Arrays.toString(cubes));

        // 14. MULTIPLY EACH ELEMENT BY 2
        System.out.println("\n14. Each Element x 2:");
        int[] doubled = Arrays.stream(arr).map(e -> e * 2).toArray();
        System.out.println("   " + Arrays.toString(doubled));

        // 15. DISTINCT ELEMENTS
        System.out.println("\n15. Distinct Elements:");
        int[] distinct = Arrays.stream(arr).distinct().toArray();
        System.out.println("   " + Arrays.toString(distinct));

        // 16. DUPLICATE ELEMENTS
        System.out.println("\n16. Duplicate Elements:");
        List<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("   " + duplicates);

        // 17. COUNT EVEN & ODD
        System.out.println("\n17. Even & Odd Count:");
        long evenCount = Arrays.stream(arr).filter(e -> e % 2 == 0).count();
        long oddCount  = Arrays.stream(arr).filter(e -> e % 2 != 0).count();
        System.out.println("   Even Count = " + evenCount);
        System.out.println("   Odd  Count = " + oddCount);

        // 18. COUNT POSITIVE, NEGATIVE & ZERO
        System.out.println("\n18. Positive / Negative / Zero:");
        long positive = Arrays.stream(arr).filter(e -> e > 0).count();
        long negative = Arrays.stream(arr).filter(e -> e < 0).count();
        long zero     = Arrays.stream(arr).filter(e -> e == 0).count();
        System.out.println("   Positive = " + positive);
        System.out.println("   Negative = " + negative);
        System.out.println("   Zero     = " + zero);

        // 19. PRODUCT OF ALL ELEMENTS
        System.out.println("\n19. Product of All Elements:");
        long product = Arrays.stream(arr)
                             .asLongStream()
                             .reduce(1L, (a, b) -> a * b);
        System.out.println("   Product = " + product);

        // 20. SECOND LARGEST
        System.out.println("\n20. Second Largest:");
        OptionalInt secondLargest = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(v -> System.out.println("   Second Largest = " + v));

        // 21. SECOND SMALLEST
        System.out.println("\n21. Second Smallest:");
        OptionalInt secondSmallest = Arrays.stream(arr)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();
        secondSmallest.ifPresent(v -> System.out.println("   Second Smallest = " + v));

        // 22. FREQUENCY OF EACH ELEMENT
        System.out.println("\n22. Frequency of Each Element:");
        Arrays.stream(arr)
              .boxed()
              .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
              .entrySet().stream()
              .sorted(Map.Entry.comparingByKey())
              .forEach(e -> System.out.println("   " + e.getKey() + " → " + e.getValue() + " time(s)"));

        // 23. anyMatch / allMatch / noneMatch
        System.out.println("\n23. Match Operations:");
        System.out.println("   Any element > 50  ? " + Arrays.stream(arr).anyMatch(e -> e > 50));
        System.out.println("   All elements > 0  ? " + Arrays.stream(arr).allMatch(e -> e > 0));
        System.out.println("   None element < 0  ? " + Arrays.stream(arr).noneMatch(e -> e < 0));

        // 24. CONVERT TO LIST
        System.out.println("\n24. Converted to List:");
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("   " + list);

        // 25. SUMMARY STATISTICS
        System.out.println("\n25. Summary Statistics:");
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
        System.out.println("   Count   = " + stats.getCount());
        System.out.println("   Sum     = " + stats.getSum());
        System.out.printf ("   Average = %.2f%n", stats.getAverage());
        System.out.println("   Min     = " + stats.getMin());
        System.out.println("   Max     = " + stats.getMax());

        System.out.println("\n" + "=".repeat(50));
        System.out.println("   ALL OPERATIONS DONE!");
        System.out.println("=".repeat(50));

        scanner.close();
    }
}
/*
 * ```
 * 
 * ---
 * 
 * ### Sample Run ``` Enter number of elements: 8 Enter 8 numbers: Element[0] =
 * 5 Element[1] = 3 Element[2] = 8 Element[3] = 1 Element[4] = 9 Element[5] = 3
 * Element[6] = -2 Element[7] = 7
 * 
 * ================================================== Input Array: [5, 3, 8, 1,
 * 9, 3, -2, 7] ==================================================
 * 
 * 1. All Elements : 5 3 8 1 9 3 -2 7 2. Sum = 34 3. Average = 4.25 4. Maximum =
 * 9 5. Minimum = -2 6. Count = 8 7. Sorted Asc : [-2, 1, 3, 3, 5, 7, 8, 9] 8.
 * Sorted Desc : [9, 8, 7, 5, 3, 3, 1, -2] 9. Even Numbers : [8, -2] 10. Odd
 * Numbers : [5, 3, 1, 9, 3, 7] 11. Above Average : [5, 8, 9, 7] 12. Squares :
 * [25, 9, 64, 1, 81, 9, 4, 49] 13. Cubes : [125, 27, 512, 1, 729, 27, -8, 343]
 * 14. Doubled : [10, 6, 16, 2, 18, 6, -4, 14] 15. Distinct : [5, 3, 8, 1, 9,
 * -2, 7] 16. Duplicates : [3] 17. Even Count = 2 | Odd Count = 6 18. Positive =
 * 7 | Negative = 1 | Zero = 0 19. Product = -15120 20. Second Largest = 8 21.
 * Second Smallest = 1 22. Frequency → -2×1 1×1 3×2 5×1 7×1 8×1 9×1 23. Any > 50
 * ? false | All > 0 ? false | None < 0 ? false 24. List : [-2, 1, 3, 3, 5, 7,
 * 8, 9] 25. Stats → Count=8, Sum=34, Avg=4.25, Min=-2, Max=9
 * ================================================== ALL OPERATIONS DONE!
 * ==================================================
 */
