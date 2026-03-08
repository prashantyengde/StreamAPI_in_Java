package claude.StreamOperation;



import java.util.*;
import java.util.stream.Collectors;

public class CharacterCounter {   // renamed class

    public void countCharacter(String str) {
        // Convert to lowercase to ignore case
        str = str.toLowerCase();

        // Use Stream and Collectors to count occurrences
        Map<Character, Long> charCountMap = str.chars()                 // IntStream of chars
                .mapToObj(c -> (char) c)                               // convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Print the result
        charCountMap.forEach((ch, count) -> System.out.println(ch + " = " + count));
        
        
        Map<Character, List<Character>> map =
                str.chars()
                   .mapToObj(c -> (char)c)
                   .collect(Collectors.groupingBy(c -> c));

        System.out.println(map);
    }

    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter();
        counter.countCharacter("PpPrPaaPsr");
    }
}
