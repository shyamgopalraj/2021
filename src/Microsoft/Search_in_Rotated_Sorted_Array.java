package Microsoft;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {

        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int smallestElementPos = 0;

        // Find rotation index which is the smallest element in the array
        int low = 0;
        int high = nums.length - 1;
        smallestElementPos = find(nums);
        if (target == nums[smallestElementPos]) {
            return smallestElementPos;
        }
        if (smallestElementPos == 0) {
            return binarySearch(low, high, nums, target);
        } else if (target < nums[0])
            return binarySearch(smallestElementPos, high, nums, target);
        return binarySearch(low, smallestElementPos, nums, target);

    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int find(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        if (nums[low] < nums[high]) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }

        }
        return low;
    }
}
