import java.util.*;

public class HashMapMadness {

    public static void main(String[] args) {


        int[] array1 = new int[] {6, 3, 7, 1, 5, 5, 2, 2, 1, 2, 9, 8};
        int[] array2 = new int[] {2, 5, 1, 3, 6, 7, 1, 2};

        int target = 10;

        var pairsFromArray1 = getPairs(array1, target);
        var pairsFromArray2 = getPairs(array2, target);

        // print the map
        printTheMap(pairsFromArray1);
        System.out.println();
        printTheMap(pairsFromArray2);

        // choose which ones go together.
        // 1 - (target-1), 2-(target-2), etc.
        for (int i = 1; i < target; i++) {
            System.out.println("array1:");
            System.out.println(String.join(",", pairsFromArray1.get(i).stream().map(Pair::toString).toList()));
            System.out.println("array2:");
            System.out.println(String.join(",", pairsFromArray2.get(target-i).stream().map(Pair::toString).toList()));
        }
    }

    private static void printTheMap(Map<Integer, Set<Pair>> myMap) {
        for(var entry : myMap.entrySet()) {
            var values =  String.join(",", entry.getValue().stream().map(Pair::toString).toList());
            System.out.println("key: " + entry.getKey() + " values: " + values);
        }
    }

    private static Map<Integer, Set<Pair>> getPairs(int[] myArray, int target) {
        Map<Integer, Set<Pair>> myMap = new HashMap<>();
        for (int i = 1; i < myArray.length; i++) {

            for (int j = 0; j < myArray.length; j++) {
                int[] subarray = Arrays.copyOfRange(myArray, j, j + i);
                int sum = 0;
                for (int k = 0; k < subarray.length; k++) {
                    sum += subarray[k];
                }
                if (sum <= target) {
                    var mySet = myMap.get(sum);
                    if (mySet == null) {
                        mySet = new HashSet<>();
                    }
                    myMap.put(sum, mySet);
                    mySet.add(Pair.of(j, j + i));
                }
            }
        }
        return myMap;
    }

    static class Pair {
        public int start;
        public int end;

        public static Pair of(int start, int end) {
            Pair p = new Pair();
            p.start = start;
            p.end = end;
            return p;
        }

        @Override
        public String toString() {
            return "("+start+","+end+")";
        }
    }
}
