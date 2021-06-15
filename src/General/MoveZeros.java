package General;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int zeroPos = -1;

        for (int i = 0; i < nums.length; i++) {
            if (zeroPos == -1 && nums[i] == 0) {
                zeroPos = i;
            } else {
                if (zeroPos != -1) {
                    // swap
                    int temp = nums[i];
                    nums[i] = 0;
                    nums[zeroPos] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
