package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Single_Number {

    // Time complexity O(n) and Space O(n)
    public int singleNumber(int[] nums) {
        int singleOccurenceNumber = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.computeIfAbsent(num, key -> 1);
            } else
                map.computeIfPresent(num, (key, val) -> val + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                singleOccurenceNumber = key;
                break;
            }
        }
        return singleOccurenceNumber;

    }

    // Time complexity O(n) and No extra space Using XOR operation
    public int bestSolution(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
