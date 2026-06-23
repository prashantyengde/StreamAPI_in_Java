package claude.StreamOperation.NPCI;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NPCIQRepeatingNumbersInList {
	public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,2,4,1,5,3,2,10,8,8);

        List<Integer> repeating = list.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println(repeating);
        
        
        List<Integer> unique = list.stream()
                .filter(n -> Collections.frequency(list, n) == 1)
                .toList();

        System.out.println(unique);
        
        
        List<Integer> repeating2= list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .distinct()
                .toList();

        System.out.println(repeating2);
    }
}
