package General;

import java.util.Arrays;

public class SquaresOfASortedArray {

    // Time Complexity O(nlogn)
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.parallelSort(nums);
        return nums;

    }

    // Two pointer approach
    // Time complexity O(n)
    public int[] twoPointerApproach(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                max = nums[left];
                left++;
            } else {
                max = nums[right];
                right--;
            }
            result[i] = max * max;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
