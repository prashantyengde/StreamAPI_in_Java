package claude.StreamOperation;

import java.util.*;
import java.util.stream.*;

public class StringArrayStreamOperations {
    public static void main(String[] args) {

        String[] words = {"Java", "Stream", "API", "Lambda", "Java",
                          "Filter", "Map", "Reduce", "Stream", "Collect"};

        System.out.println("=".repeat(55));
        System.out.println("  Input Array: " + Arrays.toString(words));
        System.out.println("=".repeat(55));

        // 1. PRINT ALL ELEMENTS
        System.out.println("\n1. Print All Elements:");
        Arrays.stream(words)
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 2. COUNT TOTAL ELEMENTS
        System.out.println("\n2. Total Count:");
        long count = Arrays.stream(words).count();
        System.out.println("  Total = " + count);

        // 3. CONVERT TO UPPERCASE
        System.out.println("\n3. Convert to UPPERCASE:");
        Arrays.stream(words)
              .map(String::toUpperCase)
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 4. CONVERT TO LOWERCASE
        System.out.println("\n4. Convert to LOWERCASE:");
        Arrays.stream(words)
              .map(String::toLowerCase)
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 5. DISTINCT ELEMENTS
        System.out.println("\n5. Distinct Elements:");
        Arrays.stream(words)
              .distinct()
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 6. DUPLICATE ELEMENTS
        System.out.println("\n6. Duplicate Elements:");
        Arrays.stream(words)
              .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
              .entrySet().stream()
              .filter(e -> e.getValue() > 1)
              .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue() + " times"));

        // 7. SORT ASCENDING
        System.out.println("\n7. Sorted Ascending (A → Z):");
        Arrays.stream(words)
              .sorted()
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 8. SORT DESCENDING
        System.out.println("\n8. Sorted Descending (Z → A):");
        Arrays.stream(words)
              .sorted(Comparator.reverseOrder())
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 9. FILTER — Words starting with specific letter
        System.out.println("\n9. Words Starting with 'S':");
        Arrays.stream(words)
              .filter(w -> w.startsWith("S"))
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 10. FILTER — Words ending with specific letter
        System.out.println("\n10. Words Ending with 'a':");
        Arrays.stream(words)
              .filter(w -> w.endsWith("a"))
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 11. FILTER — Words with length > 4
        System.out.println("\n11. Words with Length > 4:");
        Arrays.stream(words)
              .filter(w -> w.length() > 4)
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 12. FILTER — Words containing specific letter
        System.out.println("\n12. Words Containing 'a' or 'A':");
        Arrays.stream(words)
              .filter(w -> w.toLowerCase().contains("a"))
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 13. LENGTH OF EACH WORD
        System.out.println("\n13. Length of Each Word:");
        Arrays.stream(words)
              .distinct()
              .forEach(w -> System.out.println("  " + w + " → " + w.length()));

        // 14. LONGEST WORD
        System.out.println("\n14. Longest Word:");
        Arrays.stream(words)
              .max(Comparator.comparingInt(String::length))
              .ifPresent(w -> System.out.println("  " + w + " (" + w.length() + " chars)"));

        // 15. SHORTEST WORD
        System.out.println("\n15. Shortest Word:");
        Arrays.stream(words)
              .min(Comparator.comparingInt(String::length))
              .ifPresent(w -> System.out.println("  " + w + " (" + w.length() + " chars)"));

        // 16. JOIN ALL WORDS
        System.out.println("\n16. Joined with ' | ':");
        String joined = Arrays.stream(words)
                              .collect(Collectors.joining(" | "));
        System.out.println("  " + joined);

        // 17. JOIN DISTINCT WORDS WITH COMMA
        System.out.println("\n17. Distinct Words Joined with ', ':");
        String joinedDistinct = Arrays.stream(words)
                                      .distinct()
                                      .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("  " + joinedDistinct);

        // 18. FREQUENCY OF EACH WORD
        System.out.println("\n18. Frequency of Each Word:");
        Arrays.stream(words)
              .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
              .entrySet().stream()
              .sorted(Map.Entry.comparingByKey())
              .forEach(e -> System.out.println("  " + e.getKey() + " → " + e.getValue()));

        // 19. REVERSE EACH WORD
        System.out.println("\n19. Reverse Each Word:");
        Arrays.stream(words)
              .distinct()
              .map(w -> new StringBuilder(w).reverse().toString())
              .forEach(w -> System.out.print("  " + w));
        System.out.println();

        // 20. COLLECT TO LIST
        System.out.println("\n20. Collect Distinct to List:");
        List<String> list = Arrays.stream(words)
                                  .distinct()
                                  .collect(Collectors.toList());
        System.out.println("  " + list);

        // 21. COLLECT TO SET
        System.out.println("\n21. Collect to Set (no duplicates):");
        Set<String> set = Arrays.stream(words)
                                .collect(Collectors.toSet());
        System.out.println("  " + set);

        // 22. COLLECT TO MAP  word → length
        System.out.println("\n22. Collect to Map (Word → Length):");
        Arrays.stream(words)
              .distinct()
              .collect(Collectors.toMap(w -> w, String::length))
              .forEach((word, len) -> System.out.println("  " + word + " → " + len));

        // 23. anyMatch / allMatch / noneMatch
        System.out.println("\n23. Match Operations:");
        System.out.println("  Any word starts with 'J'  ? " + Arrays.stream(words).anyMatch(w -> w.startsWith("J")));
        System.out.println("  All words length > 2      ? " + Arrays.stream(words).allMatch(w -> w.length() > 2));
        System.out.println("  No word is empty           ? " + Arrays.stream(words).noneMatch(String::isEmpty));

        // 24. FIND FIRST
        System.out.println("\n24. First Word with Length > 5:");
        Arrays.stream(words)
              .filter(w -> w.length() > 5)
              .findFirst()
              .ifPresent(w -> System.out.println("  " + w));

        // 25. FLATMAP — Split each word into characters
        System.out.println("\n25. FlatMap — All Characters from All Words:");
        List<String> allChars = Arrays.stream(words)
                .distinct()
                .flatMap(w -> Arrays.stream(w.split("")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  " + allChars);

        System.out.println("\n" + "=".repeat(55));
        System.out.println("  ALL OPERATIONS DONE!");
        System.out.println("=".repeat(55));
    }
}
/*

### Output
```
=======================================================
  Input Array: [Java, Stream, API, Lambda, Java,
                Filter, Map, Reduce, Stream, Collect]
=======================================================

1.  Java  Stream  API  Lambda  Java  Filter  Map  Reduce  Stream  Collect
2.  Total = 10
3.  JAVA  STREAM  API  LAMBDA  FILTER  MAP  REDUCE  COLLECT
4.  java  stream  api  lambda  filter  map  reduce  collect
5.  Java  Stream  API  Lambda  Filter  Map  Reduce  Collect
6.  Java   → 2 times
    Stream → 2 times
7.  API  Collect  Filter  Java  Lambda  Map  Reduce  Stream
8.  Stream  Reduce  Map  Lambda  Java  Filter  Collect  API
9.  Stream  Stream
10. Java  Java  Lambda
11. Stream  Lambda  Filter  Reduce  Collect
12. Java  Java  Lambda  Map
13. Java→4  Stream→6  API→3  Lambda→6  Filter→6  Map→3  Reduce→6  Collect→7
14. Longest  → Collect (7 chars)
15. Shortest → API / Map (3 chars)
16. Java | Stream | API | Lambda | Java | Filter | Map | Reduce | Stream | Collect
17. [API, Collect, Filter, Java, Lambda, Map, Reduce, Stream]
18. API→1  Collect→1  Filter→1  Java→2  Lambda→1  Map→1  Reduce→1  Stream→2
19. avaJ  maertS  IPA  adbmaL  retliF  paM  ecudeR  tcelluC
20. [Java, Stream, API, Lambda, Filter, Map, Reduce, Collect]
21. {API, Collect, Filter, Java, Lambda, Map, Reduce, Stream}
22. Java→4  Stream→6  API→3  Lambda→6  Filter→6  Map→3  Reduce→6  Collect→7
23. Any starts 'J' ? true  |  All length > 2 ? true  |  No empty ? true
24. First word length > 5 → Stream
25. [A, C, a, b, c, d, e, f, i, J, l, L, m, M, p, r, R, S, t, u]

*/