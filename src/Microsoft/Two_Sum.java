package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (map.containsKey(num)) {
                result[0] = index;
                result[1] = map.get(num);
                break;
            } else {
                map.put(target - num, index);
            }
        }
        return result;

    }

}
