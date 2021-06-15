package Microsoft;

import java.util.Arrays;

public class Sort_Colors {

    public void sortColors(int[] nums) {

        // Pointer for val: zero
        int pointerToValZero = 0;
        // Pointer for current val
        int currentPointer = 0;
        // Pointer for val: two
        int pointerToValTwo = nums.length - 1;

        while (currentPointer <= pointerToValTwo) {

            if (nums[currentPointer] != 1) {
                if (nums[currentPointer] == 0) {
                    // swap zero pointer val and current pointer val
                    int temp = nums[currentPointer];
                    nums[currentPointer] = nums[pointerToValZero];
                    nums[pointerToValZero] = temp;
                    pointerToValZero++;
                    currentPointer++;
                } else if (nums[currentPointer] == 2 && nums[currentPointer] == 2) {
                    // swap zero pointer val and secons pointer val
                    int temp = nums[currentPointer];
                    nums[currentPointer] = nums[pointerToValTwo];
                    nums[pointerToValTwo] = temp;
                    pointerToValTwo--;
                }
            }
            else
                currentPointer++;
        }
    }

    public static void main(String[] args) {
        Sort_Colors obj = new Sort_Colors();
        int[] nums = { 1, 2, 0 };
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
