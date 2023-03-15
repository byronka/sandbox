import java.util.HashMap;
import java.util.Map;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What
 * if you cannot use additional data structures?
 */
public class CTC_Question_1_1 {


    public static void main(String[] args) {
        var testString = "abc123";
        boolean hasAllUniques = tester(testString);
        if (! hasAllUniques) throw new RuntimeException("was not all unique");

        // if I cannot use additional data structures
        hasAllUniques = tester2(testString);
        if (! hasAllUniques) throw new RuntimeException("was not all unique");
    }

    private static boolean tester(String testString) {
        Map<Character, Boolean> seenChars = new HashMap<>();
        for (int i = 0; i < testString.length(); i++) {
            Boolean result = seenChars.put(testString.charAt(i), true);
            // if we get back a non-null, then we've seen this value before.
            if (result != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean tester2(String testString) {
        for (int i = 0; i < testString.length(); i++) {
            Boolean foundAgain = testString.indexOf(testString.charAt(i), i+1) >= 0;
            // if we get back a non-null, then we've seen this value before.
            if (foundAgain) {
                return false;
            }
        }
        return true;
    }
}
