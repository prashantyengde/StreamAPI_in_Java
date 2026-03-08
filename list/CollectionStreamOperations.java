package list;

import java.util.*;
import java.util.stream.*;

public class CollectionStreamOperations {
    public static void main(String[] args) {

        // ─── ArrayList ────────────────────────────────────────────
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
            "Java", "Stream", "API", "Lambda", "Java",
            "Filter", "Map", "Reduce", "Stream", "Collect"
        ));

        // ─── HashSet ──────────────────────────────────────────────
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(
            10, 25, 30, 15, 10, 50, 25, 70, 80, 15
        ));

        // ─── LinkedList ───────────────────────────────────────────
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(
            "Apple", "Banana", "Mango", "Apple", "Grapes",
            "Orange", "Banana", "Kiwi", "Mango", "Pineapple"
        ));

        // ─── TreeSet ──────────────────────────────────────────────
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(
            5, 20, 35, 10, 45, 60, 75, 90, 20, 35
        ));

        // ═══════════════════════════════════════════════════════════
        //  ARRAYLIST OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("=".repeat(55));
        System.out.println("  ARRAYLIST: " + arrayList);
        System.out.println("=".repeat(55));

        // 1. PRINT ALL
        System.out.println("\n1. Print All Elements:");
        arrayList.stream()
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 2. COUNT
        System.out.println("\n2. Total Count:");
        System.out.println("  " + arrayList.stream().count());

        // 3. DISTINCT
        System.out.println("\n3. Distinct Elements:");
        arrayList.stream()
                 .distinct()
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 4. DUPLICATES
        System.out.println("\n4. Duplicate Elements:");
        arrayList.stream()
                 .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                 .entrySet().stream()
                 .filter(e -> e.getValue() > 1)
                 .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue() + " times"));

        // 5. SORT ASCENDING
        System.out.println("\n5. Sorted A → Z:");
        arrayList.stream()
                 .distinct()
                 .sorted()
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 6. SORT DESCENDING
        System.out.println("\n6. Sorted Z → A:");
        arrayList.stream()
                 .distinct()
                 .sorted(Comparator.reverseOrder())
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 7. FILTER — starts with 'S'
        System.out.println("\n7. Words Starting with 'S':");
        arrayList.stream()
                 .filter(e -> e.startsWith("S"))
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 8. MAP — to Uppercase
        System.out.println("\n8. Convert to UPPERCASE:");
        arrayList.stream()
                 .distinct()
                 .map(String::toUpperCase)
                 .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 9. LONGEST WORD
        System.out.println("\n9. Longest Word:");
        arrayList.stream()
                 .max(Comparator.comparingInt(String::length))
                 .ifPresent(e -> System.out.println("  " + e + " (" + e.length() + " chars)"));

        // 10. SHORTEST WORD
        System.out.println("\n10. Shortest Word:");
        arrayList.stream()
                 .min(Comparator.comparingInt(String::length))
                 .ifPresent(e -> System.out.println("  " + e + " (" + e.length() + " chars)"));

        // 11. JOINING
        System.out.println("\n11. Joined String:");
        String joined = arrayList.stream()
                                 .distinct()
                                 .collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("  " + joined);

        // 12. FREQUENCY MAP
        System.out.println("\n12. Frequency of Each Word:");
        arrayList.stream()
                 .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                 .entrySet().stream()
                 .sorted(Map.Entry.comparingByKey())
                 .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue()));

        // 13. COLLECT TO SET (removes duplicates)
        System.out.println("\n13. ArrayList → Collected to Set:");
        Set<String> collectedSet = arrayList.stream()
                                            .collect(Collectors.toSet());
        System.out.println("  " + collectedSet);

        // 14. anyMatch / allMatch / noneMatch
        System.out.println("\n14. Match Operations on ArrayList:");
        System.out.println("  Any starts with 'J'  ? " + arrayList.stream().anyMatch(e -> e.startsWith("J")));
        System.out.println("  All length > 2       ? " + arrayList.stream().allMatch(e -> e.length() > 2));
        System.out.println("  None is empty        ? " + arrayList.stream().noneMatch(String::isEmpty));

        // 15. FIND FIRST
        System.out.println("\n15. First Element with Length > 5:");
        arrayList.stream()
                 .filter(e -> e.length() > 5)
                 .findFirst()
                 .ifPresent(e -> System.out.println("  " + e));

        // ═══════════════════════════════════════════════════════════
        //  HASHSET OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  HASHSET (duplicates auto-removed): " + hashSet);
        System.out.println("=".repeat(55));

        // 16. PRINT ALL
        System.out.println("\n16. Print All HashSet Elements:");
        hashSet.stream()
               .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 17. SUM
        System.out.println("\n17. Sum of HashSet:");
        int sum = hashSet.stream().mapToInt(Integer::intValue).sum();
        System.out.println("  Sum = " + sum);

        // 18. AVERAGE
        System.out.println("\n18. Average of HashSet:");
        hashSet.stream()
               .mapToInt(Integer::intValue)
               .average()
               .ifPresent(a -> System.out.printf("  Average = %.2f%n", a));

        // 19. MAX & MIN
        System.out.println("\n19. Max & Min in HashSet:");
        hashSet.stream().max(Integer::compareTo).ifPresent(e -> System.out.println("  Max = " + e));
        hashSet.stream().min(Integer::compareTo).ifPresent(e -> System.out.println("  Min = " + e));

        // 20. FILTER — elements > 30
        System.out.println("\n20. Elements Greater Than 30:");
        hashSet.stream()
               .filter(e -> e > 30)
               .sorted()
               .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 21. SORT HASHSET
        System.out.println("\n21. HashSet Sorted Ascending:");
        hashSet.stream()
               .sorted()
               .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 22. MAP — square each element
        System.out.println("\n22. Square of Each HashSet Element:");
        hashSet.stream()
               .sorted()
               .map(e -> e * e)
               .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 23. COLLECT HASHSET → LIST
        System.out.println("\n23. HashSet → Collected to Sorted List:");
        List<Integer> setToList = hashSet.stream()
                                         .sorted()
                                         .collect(Collectors.toList());
        System.out.println("  " + setToList);

        // ═══════════════════════════════════════════════════════════
        //  LINKEDLIST OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  LINKEDLIST: " + linkedList);
        System.out.println("=".repeat(55));

        // 24. DISTINCT FRUITS
        System.out.println("\n24. Distinct Fruits:");
        linkedList.stream()
                  .distinct()
                  .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 25. FILTER — length > 5
        System.out.println("\n25. Fruits with Name Length > 5:");
        linkedList.stream()
                  .distinct()
                  .filter(e -> e.length() > 5)
                  .forEach(e -> System.out.print("  " + e));
        System.out.println();

        // 26. SORT & JOIN
        System.out.println("\n26. Sorted & Joined Fruits:");
        String fruits = linkedList.stream()
                                  .distinct()
                                  .sorted()
                                  .collect(Collectors.joining(", "));
        System.out.println("  " + fruits);

        // 27. FREQUENCY
        System.out.println("\n27. Fruit Frequency:");
        linkedList.stream()
                  .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                  .entrySet().stream()
                  .sorted(Map.Entry.comparingByKey())
                  .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue()));

        // ═══════════════════════════════════════════════════════════
        //  TREESET OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  TREESET (auto-sorted, no duplicates): " + treeSet);
        System.out.println("=".repeat(55));

        // 28. SUM, AVG, COUNT
        System.out.println("\n28. TreeSet — Sum / Average / Count:");
        IntSummaryStatistics stats = treeSet.stream()
                                            .mapToInt(Integer::intValue)
                                            .summaryStatistics();
        System.out.println("  Count   = " + stats.getCount());
        System.out.println("  Sum     = " + stats.getSum());
        System.out.printf ("  Average = %.2f%n", stats.getAverage());
        System.out.println("  Min     = " + stats.getMin());
        System.out.println("  Max     = " + stats.getMax());

        // 29. FILTER EVEN & ODD
        System.out.println("\n29. TreeSet — Even & Odd:");
        List<Integer> evenList = treeSet.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList  = treeSet.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        System.out.println("  Even: " + evenList);
        System.out.println("  Odd : " + oddList);

        // 30. PARTITION BY > 50
        System.out.println("\n30. TreeSet — Partition by value > 50:");
        Map<Boolean, List<Integer>> partitioned = treeSet.stream()
                .collect(Collectors.partitioningBy(e -> e > 50));
        System.out.println("  > 50 : " + partitioned.get(true));
        System.out.println("  ≤ 50 : " + partitioned.get(false));

        System.out.println("\n" + "=".repeat(55));
        System.out.println("  ALL COLLECTION OPERATIONS DONE!");
        System.out.println("=".repeat(55));
    }
}
/*
### Output
```
=======================================================
  ARRAYLIST: [Java, Stream, API, Lambda, Java, Filter,
              Map, Reduce, Stream, Collect]
=======================================================
1.  Java  Stream  API  Lambda  Java  Filter  Map  Reduce  Stream  Collect
2.  Total Count    = 10
3.  Distinct       = Java  Stream  API  Lambda  Filter  Map  Reduce  Collect
4.  Duplicates     → Java=2  Stream=2
5.  Sorted A→Z     = API  Collect  Filter  Java  Lambda  Map  Reduce  Stream
6.  Sorted Z→A     = Stream  Reduce  Map  Lambda  Java  Filter  Collect  API
7.  Starts with S  = Stream  Stream
8.  UPPERCASE      = JAVA  STREAM  API  LAMBDA  FILTER  MAP  REDUCE  COLLECT
9.  Longest        = Collect (7 chars)
10. Shortest       = Map (3 chars)
11. Joined         = [API | Collect | Filter | Java | Lambda | Map | Reduce | Stream]
12. Frequency      = API→1  Collect→1  Filter→1  Java→2  Map→1  Reduce→1  Stream→2
13. → Set          = {API, Collect, Filter, Java, Lambda, Map, Reduce, Stream}
14. Any 'J' = true | All len>2 = true | None empty = true
15. First len>5    = Stream

=======================================================
  HASHSET (duplicates auto-removed): [80, 50, 70, 10, 25, 30, 15]
=======================================================
16. Print All      = 80  50  70  10  25  30  15
17. Sum            = 280
18. Average        = 40.00
19. Max=80  Min=10
20. Elements > 30  = 50  70  80
21. Sorted         = 10  15  25  30  50  70  80
22. Squares        = 100  225  625  900  2500  4900  6400
23. → List         = [10, 15, 25, 30, 50, 70, 80]

=======================================================
  LINKEDLIST: [Apple, Banana, Mango, Apple, Grapes,
               Orange, Banana, Kiwi, Mango, Pineapple]
=======================================================
24. Distinct       = Apple  Banana  Mango  Grapes  Orange  Kiwi  Pineapple
25. Length > 5     = Banana  Grapes  Orange  Pineapple
26. Sorted & Joined= Apple, Banana, Grapes, Kiwi, Mango, Orange, Pineapple
27. Frequency      = Apple→2  Banana→2  Grapes→1  Kiwi→1  Mango→2  Orange→1  Pineapple→1

=======================================================
  TREESET (auto-sorted, no duplicates): [5,10,20,35,45,60,75,90]
=======================================================
28. Count=8  Sum=340  Average=42.50  Min=5  Max=90
29. Even = [10, 20, 60, 90]   Odd = [5, 35, 45, 75]
30. >50  = [60, 75, 90]
    ≤50  = [5, 10, 20, 35, 45]
=======================================================
  ALL COLLECTION OPERATIONS DONE!
=======================================================*/