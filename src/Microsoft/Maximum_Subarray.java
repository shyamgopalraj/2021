package Microsoft;

public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int running_max_sum = nums[0];

        for (int index = 1; index < nums.length; index++) {
            running_max_sum = Math.max(nums[index], running_max_sum + nums[index]);
            max_sum = Math.max(running_max_sum, max_sum);
        }
        return max_sum;
    }

}
