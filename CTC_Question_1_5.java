/**
 * One Away: There are three types of edits that can be performed on strings: insert
 * a character, remove a character, or replace a character. Given two strings, write
 * a function to check if they are one edit (or zero edits) away.
 * EXAMPLE:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class CTC_Question_1_5 {

    public static void main(String[] args) {

        boolean isOneEditAway = solution(Pair.of("pale", "ple"));
        if (! isOneEditAway) throw new RuntimeException();

        isOneEditAway = solution(Pair.of("pales", "pale"));
        if (! isOneEditAway) throw new RuntimeException();

        isOneEditAway = solution(Pair.of("pale", "bale"));
        if (! isOneEditAway) throw new RuntimeException();

        isOneEditAway = solution(Pair.of("pale", "bake"));
        if (isOneEditAway) throw new RuntimeException();
    }

    static class Pair {
        public String left;
        public String right;

        public static Pair of(String left, String right) {
            Pair p = new Pair();
            p.left = left;
            p.right = right;
            return p;
        }
    }

    private static boolean solution(Pair pair) {
        // what is the difference between these words?

        // are they the same length? then just check each
        // letter between them and see if anything differs.
        // one different letter is allowed
        if (pair.left.length() == pair.right.length()) {
            int numberOfDiffs = 0;
            for (int i = 0; i < pair.left.length(); i++) {
                char lChar = pair.left.charAt(i);
                char rChar = pair.right.charAt(i);

                if (lChar != rChar) {
                    numberOfDiffs += 1;
                }

                if (numberOfDiffs > 1) {
                    return false;
                }
            }
        }

        // not the same length?

        // differ by more than one char? definitely more than one edit
        if (Math.abs(pair.left.length() - pair.right.length()) > 1) return false;

        // differ by exactly one? This is the tricky condition.
        if (Math.abs(pair.left.length() - pair.right.length()) == 1) {
            // we'll loop through the characters in the longer one.
            // comparing to the other.  when we hit a character that doesn't
            // exist in the other, we'll mark it as a diff and step forward in
            // the longer but not the shorter and keep comparing.  If we find
            // any more differences, it's more than one edit.
            String longer = null;
            String shorter = null;
            if (pair.left.length() > pair.right.length()) {
                longer = pair.left;
                shorter = pair.right;
            } else {
                longer = pair.right;
                shorter = pair.left;
            }

            int numberOfDiffs_2 = 0;
            int indexInShorter = 0;

            // only go to the length of the shorter since, if we
            // make it to the end, we presume it's the last character that differs.
            for (int i = 0; i < shorter.length(); i++) {
                if (longer.charAt(i) != shorter.charAt(indexInShorter)) {
                    numberOfDiffs_2 += 1;
                } else {
                    indexInShorter += 1;
                }

                if (numberOfDiffs_2 > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
