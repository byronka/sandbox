import java.util.Arrays;

/**
 * Check permutation: given two strings, write a method to decide if one is a
 * permutation of the other
 */
public class CTC_Question_1_2 {
    public static void main(String[] args) {
        var a = "";
        var b = "";
        boolean isPermutation = checkIfPermutation(a,b);
        System.out.print("a: " + a + " and b: " + b);
        if (isPermutation) {
            System.out.println(" are permutations of each other");
        } else {
            System.out.println(" are not permutations of each other");
        }
    }

    private static boolean checkIfPermutation(String a, String b) {
        char[] a1 = a.toCharArray();
        Arrays.sort(a1);
        char[] b1 = b.toCharArray();
        Arrays.sort(b1);
        for(int i = 0; i < a1.length; i++) {
            if (a1[i] != b1[i]) {
                return false;
            }
        }
        return true;
    }
}
