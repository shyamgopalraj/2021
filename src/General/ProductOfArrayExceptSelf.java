package General;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int numLength = nums.length;

        int[] leftProduct = new int[numLength];
        int[] rightProduct = new int[numLength];

        leftProduct[0] = 1;
        for (int i = 1; i < numLength; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[numLength - 1] = 1;
        for (int i = numLength - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] result = new int[numLength];
        for (int i = 0; i < numLength; i++)
            result[i] = leftProduct[i] * rightProduct[i];
        return result;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
