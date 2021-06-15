package General;

import java.util.Arrays;

public class Sort_an_Array {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums) {

        if (nums.length <= 1)
            return nums;

        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);

    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                result[resultIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < leftArray.length) {
            result[resultIndex] = leftArray[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < rightArray.length) {
            result[resultIndex] = rightArray[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 5, 2, 3, 1 };
        Sort_an_Array obj = new Sort_an_Array();
        System.out.println(Arrays.toString(obj.sortArray(array)));

    }

}
