import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CodeTest2 {

    public static void main(String[] args) {

    }

    static long hashMap(String[] queryType, int[][] query) {
        long sum = 0;
        Integer currKey = 0;
        Integer currValue = 0;
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < queryType.length; i++) {
            String currQuery = queryType[i];
            switch (currQuery) {
                case "insert":
                    HashMap<Integer, Integer> copiedValues = new HashMap<>();
                    if (currKey != 0 || currValue != 0) {
                        Set<Integer> keys = values.keySet();
                        for (Integer key : keys) {
                            copiedValues.put(key + currKey, values.get(key) + currValue);
                        }
                        values.clear();
                        values.putAll(copiedValues);
                        currValue = 0;
                        currKey = 0;
                    }
                    values.put(query[i][0], query[i][1]);
                    break;
                case "addToValue":
                    currValue += values.isEmpty() ? 0 : query[i][0];
                    break;
                case "addToKey":
                    currKey += values.isEmpty() ? 0 : query[i][0];
                    break;
                case "get":
                    copiedValues = new HashMap<>();
                    if (currKey != 0 || currValue != 0) {
                        Set<Integer> keys = values.keySet();
                        for (Integer key : keys) {
                            copiedValues.put(key + currKey, values.get(key) + currValue);
                        }
                        values.clear();
                        values.putAll(copiedValues);
                        currValue = 0;
                        currKey = 0;
                    }
                    sum += values.get(query[i][0]);
            }
        }
        return sum;
    }
}
