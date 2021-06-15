package General;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (nums[start] == val) {
                while (nums[end] == val && start <= end) {
                    end--;
                }
                if(start > end) {
                    break;
                }
                else {
                    nums[start]=nums[end];
                }
            }
            start++;
        }
        return start;
    }

    private int[] swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(nums, 2);
        System.out.println(length);
    }

}
