package General;

import java.util.Arrays;

public class QuickSort {

    public static void solution(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotPos = partition(nums, low, high);
            quickSort(nums, low, pivotPos - 1);
            quickSort(nums, pivotPos + 1, high);
        }

    }

    private static int partition(int[] nums, int low, int high) {

        int pivotElement = nums[high];
        for (int index = low; index < high; index++) {
            if (nums[index] < pivotElement) {
                // swap index and low
                int temp = nums[index];
                nums[index] = nums[low];
                nums[low] = temp;
                low++;
            }
        }

        // swap pivot element with low pos
        int temp = nums[low];
        nums[low] = pivotElement;
        nums[high] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 5, 3, 1, 2 };
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
