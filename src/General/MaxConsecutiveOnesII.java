package General;

public class MaxConsecutiveOnesII {

    // Sliding window
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int right = 0;
        int maxOnes = 0;

        for (; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
                if (zeroCount > 1) {

                    maxOnes = Math.max(maxOnes, right - left);

                    while (zeroCount != 1) {
                        if (nums[left] == 0) {
                            zeroCount--;
                        }
                        left++;
                    }
                }
            }
        }

        return Math.max(maxOnes, right - left);

    }

    public static void main(String[] args) {

    }

}
