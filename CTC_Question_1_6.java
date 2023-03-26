/**
 * String compression: implement a method to perform basic string compression using
 * the counts of repeated characters.  For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method
 * should return the original string.  You can assume the string has only uppercase and lowercase letters (a-z)
 */
public class CTC_Question_1_6 {

    public static void main(String[] args) {
        String result = solution("aabcccccaaa");
        if (! result.equals("a2b1c5a3")) throw new RuntimeException("solution failed. result was " + result);
        result = solution("abc");
        if (! result.equals("abc")) throw new RuntimeException("solution failed. result was " + result);
    }

    private static String solution(String input) {
        String compressedString = compressor(input);
        if (compressedString.length() < input.length()) {
            return compressedString;
        } else {
            return input;
        }

    }

    private static String compressor(String input) {

        StringBuilder output = new StringBuilder();
        if (input.length() == 0) return output.toString();
        int currentLetterCount = 1;
        char previousChar = input.charAt(0);
        for (int i = 1; i <= input.length(); i++) {
            if (i == input.length()) {
                output.append(previousChar).append(currentLetterCount);
                return output.toString();
            }
            if (input.charAt(i) == previousChar) {
                currentLetterCount += 1;
            } else {
                output.append(previousChar).append(currentLetterCount);
                currentLetterCount = 1;
            }
            previousChar = input.charAt(i);
        }
        return output.toString();
    }

}
