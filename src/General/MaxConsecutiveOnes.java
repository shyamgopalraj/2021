package General;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == 1) {
                count++;
                i++;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int result = maxConsecutiveOnes.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 });
        System.out.println("result: " + result);
    }

}
