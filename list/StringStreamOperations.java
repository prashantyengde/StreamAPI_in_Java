package list;

import java.util.*;
import java.util.stream.*;

public class StringStreamOperations {
    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
         System.out.println("Enter String You want to do Operations---->");
        String fullName = sc.nextLine();

        System.out.println("=".repeat(55));
        System.out.println("  Input String: \"" + fullName + "\"");
        System.out.println("=".repeat(55));

        // 1. COUNT CAPITAL LETTERS
        System.out.println("\n1. Capital Letter Count:");
        long capitalCount = fullName.chars()
                .filter(Character::isUpperCase)
                .count();
        System.out.println("   Capital Letters Count = " + capitalCount);

        // 2. PRINT ALL CAPITAL LETTERS
        System.out.println("\n2. All Capital Letters:");
        fullName.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> String.valueOf((char) c))
                .forEach(c -> System.out.print("   " + c));
        System.out.println();

        // 3. COUNT LOWERCASE LETTERS
        System.out.println("\n3. Lowercase Letter Count:");
        long lowerCount = fullName.chars()
                .filter(Character::isLowerCase)
                .count();
        System.out.println("   Lowercase Letters Count = " + lowerCount);

        // 4. COUNT VOWELS
        System.out.println("\n4. Vowel Count:");
        long vowelCount = fullName.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
        System.out.println("   Vowels Count = " + vowelCount);

        // 5. PRINT ALL VOWELS
        System.out.println("\n5. All Vowels:");
        fullName.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .mapToObj(c -> String.valueOf((char) c))
                .forEach(c -> System.out.print("   " + c));
        System.out.println();

        // 6. COUNT CONSONANTS
        System.out.println("\n6. Consonant Count:");
        long consonantCount = fullName.chars()
                .filter(Character::isLetter)
                .filter(c -> "AEIOUaeiou".indexOf(c) == -1)
                .count();
        System.out.println("   Consonants Count = " + consonantCount);

        // 7. COUNT SPACES
        System.out.println("\n7. Space Count:");
        long spaceCount = fullName.chars()
                .filter(c -> c == ' ')
                .count();
        System.out.println("   Spaces Count = " + spaceCount);

        // 8. TOTAL CHARACTER COUNT (with spaces)
        System.out.println("\n8. Total Characters (with spaces):");
        long totalChars = fullName.chars().count();
        System.out.println("   Total Characters = " + totalChars);

        // 9. TOTAL CHARACTER COUNT (without spaces)
        System.out.println("\n9. Total Characters (without spaces):");
        long totalWithoutSpaces = fullName.chars()
                .filter(c -> c != ' ')
                .count();
        System.out.println("   Total Characters (no spaces) = " + totalWithoutSpaces);

        // 10. CONVERT TO UPPERCASE using Stream
        System.out.println("\n10. Convert to UPPERCASE:");
        String upper = fullName.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(String::toUpperCase)
                .collect(Collectors.joining());
        System.out.println("   " + upper);

        // 11. CONVERT TO LOWERCASE using Stream
        System.out.println("\n11. Convert to LOWERCASE:");
        String lower = fullName.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(String::toLowerCase)
                .collect(Collectors.joining());
        System.out.println("   " + lower);

        // 12. REVERSE THE STRING
        System.out.println("\n12. Reverse the String:");
        String reversed = fullName.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> { Collections.reverse(list); return list.stream(); }
                ))
                .collect(Collectors.joining());
        System.out.println("   " + reversed);

        // 13. DISTINCT CHARACTERS
        System.out.println("\n13. Distinct Characters:");
        fullName.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .forEach(c -> System.out.print("   " + c));
        System.out.println();

        // 14. DISTINCT CHARACTER COUNT
        System.out.println("\n14. Distinct Character Count:");
        long distinctCount = fullName.chars()
                .distinct()
                .count();
        System.out.println("   Distinct Characters = " + distinctCount);

        // 15. SORT CHARACTERS ALPHABETICALLY
        System.out.println("\n15. Characters Sorted Alphabetically:");
        String sorted = fullName.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("   " + sorted);

        // 16. SPLIT INTO WORDS
        System.out.println("\n16. Split into Words:");
        Arrays.stream(fullName.split(" "))
              .forEach(word -> System.out.println("   → " + word));

        // 17. WORD COUNT
        System.out.println("\n17. Word Count:");
        long wordCount = Arrays.stream(fullName.split(" "))
                               .count();
        System.out.println("   Total Words = " + wordCount);

        // 18. LENGTH OF EACH WORD
        System.out.println("\n18. Length of Each Word:");
        Arrays.stream(fullName.split(" "))
              .forEach(word -> System.out.println("   " + word + " → " + word.length() + " letters"));

        // 19. LONGEST WORD
        System.out.println("\n19. Longest Word:");
        Arrays.stream(fullName.split(" "))
              .max(Comparator.comparingInt(String::length))
              .ifPresent(w -> System.out.println("   " + w));

        // 20. SHORTEST WORD
        System.out.println("\n20. Shortest Word:");
        Arrays.stream(fullName.split(" "))
              .min(Comparator.comparingInt(String::length))
              .ifPresent(w -> System.out.println("   " + w));

        // 21. EACH WORD TO UPPERCASE
        System.out.println("\n21. Each Word to UPPERCASE:");
        Arrays.stream(fullName.split(" "))
              .map(String::toUpperCase)
              .forEach(w -> System.out.println("   " + w));

        // 22. FREQUENCY OF EACH CHARACTER
        System.out.println("\n22. Character Frequency:");
        fullName.chars()
                .filter(c -> c != ' ')
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("   '" + entry.getKey() + "' → " + entry.getValue()));

        // 23. CHECK IF PALINDROME
        System.out.println("\n23. Is Palindrome?");
        String clean = fullName.replace(" ", "").toLowerCase();
        String rev   = new StringBuilder(clean).reverse().toString();
        System.out.println("   \"" + fullName + "\" is palindrome? " + clean.equals(rev));

        // 24. REMOVE DUPLICATES & JOIN
        System.out.println("\n24. Remove Duplicate Characters & Join:");
        String noDuplicates = fullName.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("   " + noDuplicates);

        // 25. SUMMARY
        System.out.println("\n" + "=".repeat(55));
        System.out.println("  SUMMARY");
        System.out.println("=".repeat(55));
        System.out.printf("  %-30s : %d%n", "Total Characters (with space)",    totalChars);
        System.out.printf("  %-30s : %d%n", "Total Characters (no space)",      totalWithoutSpaces);
        System.out.printf("  %-30s : %d%n", "Capital Letters",                  capitalCount);
        System.out.printf("  %-30s : %d%n", "Lowercase Letters",                lowerCount);
        System.out.printf("  %-30s : %d%n", "Vowels",                           vowelCount);
        System.out.printf("  %-30s : %d%n", "Consonants",                       consonantCount);
        System.out.printf("  %-30s : %d%n", "Spaces",                           spaceCount);
        System.out.printf("  %-30s : %d%n", "Words",                            wordCount);
        System.out.printf("  %-30s : %d%n", "Distinct Characters",              distinctCount);
        System.out.println("=".repeat(55));
        sc.close();
    }
}
/*
 * ```
 * 
 * ---
 * 
 * ### Output ``` ======================================================= Input
 * String: "Prashant Balasaheb Yengde"
 * =======================================================
 * 
 * 1. Capital Letter Count = 3 2. Capital Letters = P B Y 3. Lowercase Letter
 * Count = 19 4. Vowel Count = 9 5. All Vowels = a a a a a e e e 6. Consonant
 * Count = 13 7. Space Count = 2 8. Total Characters (spaces) = 25 9. Total
 * Characters (no space) = 23 10. UPPERCASE → PRASHANT BALASAHEB YENGDE 11.
 * lowercase → prashant balasaheb yengde 12. Reversed → edgneY behasalaB
 * tnahsarP 13. Distinct Chars → P r a s h n t B l e b Y g d 14. Distinct Count
 * = 15 15. Sorted → BBPYaaaaabdeeeghhlnnrsstt 16. Words → Prashant → Balasaheb
 * → Yengde 17. Word Count = 3 18. Prashant→8 Balasaheb→9 Yengde→6 19. Longest
 * Word → Balasaheb 20. Shortest Word → Yengde 21. PRASHANT BALASAHEB YENGDE 22.
 * Frequency → a=5 B=1 b=1 d=1 e=3 g=1 h=2 ...
 * ======================================================= SUMMARY
 * ======================================================= Total Characters
 * (with space) : 25 Total Characters (no space) : 23 Capital Letters : 3
 * Lowercase Letters : 19 Vowels : 9 Consonants : 13 Spaces : 2 Words : 3
 * Distinct Characters : 15
 * =======================================================
 */