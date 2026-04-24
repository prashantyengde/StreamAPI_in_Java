package claude.StreamOperation;

public class CharacterCountDifferentapproach {
 
    public static void main(String[] args) {
        String str = "Prashant Balasaheb Yengde Prashant";

        // Convert to lowercase to count letters ignoring case
          str = str.toLowerCase();

        // Array to store counts for letters 'a' to 'z'
        int[] counts = new int[26]; // 26 letters

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                counts[ch - 'a']++; // increment the corresponding index
            }
        }

        // Print the counts
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + counts[i]);
            }
        }
    }
}