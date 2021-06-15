package General;

public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {

        int evenNumberCount = 0;
        for (int num : nums) {
            int digitCount = 0;
            while (num != 0) {
                num = num / 10;
                digitCount++;
            }
            if (digitCount % 2 == 0) {
                evenNumberCount++;
            }
        }
        return evenNumberCount;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
