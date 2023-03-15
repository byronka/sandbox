import java.util.HashMap;
import java.util.Map;

/**
 * Palindrome permutation: Given a string, write a function to check if it is a
 * permutation of a palindrome. A palindrome is a word or phrase that is the same
 * forwards and backwards. A permutation is a rearrangement of letters. The palindrome
 * does not need to be limited to just dictionary words.
 * EXAMPLE:
 * input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
public class CTC_Question_1_4 {

    public static void main(String[] args) {
        String input = "Tact Coa";

        boolean isPalindromable = solution(input);

        if (! isPalindromable) throw new RuntimeException();
    }

    private static boolean solution(String input) {
        Map<Character, Integer> countOfChars = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = Character.toLowerCase(input.charAt(i));

            // we don't want to care about whitespace or exotic chars.
            if (! "abcdefghijklmnopqrstuvwxyz".contains(String.valueOf(currentChar))) continue;

            var count = countOfChars.get(currentChar);
            if (count == null) {
                countOfChars.put(currentChar, 1);
            } else {
                countOfChars.put(currentChar, count += 1);
            }
        }

        // now we have a count of chars.

        // all we have to do is make sure nearly everything is a multiple of 2,
        // except it is allowed to have *exactly* 0 or 1 chars that are odd.
        // so really I guess we merely have to loop through our counts and
        // make sure we have 0 or 1 odd value.
        int countOfOdds = 0;
        for (Map.Entry<Character, Integer> entry : countOfChars.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                countOfOdds += 1;
            }
            if (countOfOdds > 1) {
                return false;
            }
        }
        return true;
    }

}
