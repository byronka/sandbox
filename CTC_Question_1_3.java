/**
 * URLify: Write a method to replace all spaces in a string with "%20". You may
 * assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if
 * implementing in Java, please use a character array so that you can perform this
 * operation in place.)
 * EXAMPLE:
 * Input:  "Mr John Smith   ", 13
 * Output: "Mr%20John%20Smith"
 */
public class CTC_Question_1_3 {
    public static void main(String[] args) {
        char[] input =    "Mr John Smith    ".toCharArray();
        char[] expected = "Mr%20John%20Smith".toCharArray();

        solution(input, 13);
        if (!new String(input).equals(new String(expected))) throw new RuntimeException("input did not match expected (\""+expected+"\").  was: " + input);
    }

    private static void solution(char[] input, int endOfString) {

        // *** No need to do the following since we are given the length of the string

//        // first let's index from the back until we hit a non-space
//        int lastIndexOfChars = input.length-1;
//        for (; lastIndexOfChars >= 0; lastIndexOfChars--) {
//            if (input[lastIndexOfChars] != ' ') {
//                break;
//            }
//        }

        // now our value lastIndexOfChars is sitting at the last non-space character.
        // set up a pointer to the end for copying
        int pointerAtEnd = input.length - 1;
        for (int i = endOfString-1; i >= 0; i--) {
            if (input[i] != ' ') {
                input[pointerAtEnd] = input[i];
                pointerAtEnd -= 1;
            } else {
                input[pointerAtEnd-2] = '%';
                input[pointerAtEnd-1] = '2';
                input[pointerAtEnd-0] = '0';
                pointerAtEnd -= 3;
            }

        }
    }
}
