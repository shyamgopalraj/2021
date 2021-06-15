package Amazon;

import java.util.Arrays;

public class Three_Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {

        int length = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int index = 0; index < length; index++) {
            int low = index + 1;
            int high = length - 1;
            while (low < high) {
                int sum = nums[index] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (diff == 0) {
                    break;
                } else if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return target - diff;

    }

    public static void main(String[] args) {
        Three_Sum_Closest obj = new Three_Sum_Closest();
        int[] nums = { -1, 2, 1, -4 };
        int result = obj.threeSumClosest(nums, 1);
        System.out.println(result);
    }

}
