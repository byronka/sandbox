import java.util.ArrayList;
import java.util.List;

public class CodeTest1 {
    public static void main(String[] args) {
        System.out.println("hi world");
        final var result = subset_equality("1741380");
        if (! (result.get(0).equals("17_413_80") && result.get(1).equals("174_1380") && result.get(2).equals("1741380") )) {
            throw new RuntimeException("result was " + result );
        }

        // input for some Depth-first search algorithm I found online
        int[] input = new int[] {1,2,3,4,5};
        final var result = canPartitionKSubsets(input, 3);
        System.out.println(result);
    }

    // found this code online, as contrast to my work
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        if(k <= 0 || sum%k != 0) {
            return false;
        }
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }

    // found this code online, as contrast to my work
    public static boolean canPartition
            (int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {

        if(k==1) {
            return true;
        }

        if(cur_sum == target && cur_num>0) {
            return canPartition(nums, visited, 0, k-1, 0, 0, target);
        }

        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target)) {
                    return true;
                }
                visited[i] = 0;
            }
        }

        return false;
    }

    public static List<String> subset_equality(String arr) {
        List<String> resultList = new ArrayList<>();
        /*
         we'll start with just the first character as a digit
         and see whether we can work with that, then move on to
         two digits, all the way up to the length of the total
         */
        for (int i = 1; i < arr.length(); i++) {

            // get the sum of i-count digits
            int initialSum = 0;
            for (int j = 0; j < i; j++) {
                int digit = Integer.parseInt(String.valueOf(arr.charAt(j)));
                initialSum += digit;
            }

            // now we have an initial sum to compare against.
            // The question is, can we get that same sum if we continue
            // down the string?

            // starting at the digit after, here we go...
            int tempSum = 0;
            // we check for zeroes if we've hit the target value but want to make
            // sure we grab any subsequent zeroes.
            boolean checkingForZeroes = false;
            String potentialBuiltUpString = arr.substring(0,i) + "_";
            for (int k = i; k < arr.length() ; k++) {

                String s = String.valueOf(arr.charAt(k));
                int digit = Integer.parseInt(s);
                tempSum += digit;

                if (checkingForZeroes) {
                    if (digit == 0) {
                        potentialBuiltUpString += s;

                    } else {
                        checkingForZeroes = false;
                        potentialBuiltUpString += "_" + s;
                    }

                } else {
                    potentialBuiltUpString += s;
                }

                if (k == arr.length() - 1 && tempSum == 0 && checkingForZeroes) {
                    resultList.add(potentialBuiltUpString);
                    break;
                }


                if (tempSum < initialSum) {
                    // if we're under, keep going
                } else if (tempSum == initialSum) {
                    // if we hit it on the head, cool, reset tempsum and move to the
                    // next index
                    checkingForZeroes = true;
                    tempSum = 0;
                } else {
                    // if we're greater, without having hit equal-to, then bail -
                    // it ain't gonna work for the initial sum
                    break;
                }


            }


        }
        resultList.add(arr);
        return resultList;
    }

}
