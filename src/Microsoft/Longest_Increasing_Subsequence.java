package Microsoft;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    // Time complexity O(n2) Dynamic Programming
    public int findLIS(int[] nums) {

        int length = 0;

        int[] dp = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            dp[index] = 1;
        }

        int prev = 0;
        int cur = 1;
        while (cur < nums.length) {
            while (prev < cur) {
                if (nums[prev] < nums[cur]) {
                    dp[cur] = Math.max(dp[cur], dp[prev] + 1);
                    length = Math.max(dp[cur], length);
                }
                prev++;
            }
            prev = 0;
            cur++;
        }

        return length;

    }

    // Time Complexity: nlogn
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, length, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == length) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Longest_Increasing_Subsequence obj = new Longest_Increasing_Subsequence();
        int[] nums = {10,9,2,5,3,7,101,18 };
        int result = obj.lengthOfLIS(nums);
        // nlogn time complexity
        System.out.println(result);
        int resultbyDP = obj.findLIS(nums);
        // O(n2) time complexity using DP
        System.out.println(result);
    }

}
