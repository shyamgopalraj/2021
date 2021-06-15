package Amazon;

import java.util.*;

//Best Time complexity O(n2)
public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        // Sorting is important as the original order is not important
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            // if val is greater than zero than adding anything would not lower it as its sorted in increasing order
            if (nums[index] <= 0) {
                // compare current index value and prev index value is not same as it will create duplicates in result
                // array
                if (index > 0 && nums[index] == nums[index - 1]) {
                    continue;
                }
                int low = index + 1;
                int high = nums.length - 1;
                while (low < high) {

                    int sum = nums[index] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(nums[index]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        // Increment low index to next
                        low++;
                        // if next low index val is same as prev low index, increment till not equal.
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }

                    } else {
                        // increment low since sum is less tha zero.
                        if (sum < 0) {
                            low++;
                            // decrement high since we sum is greater than zero.
                        } else {
                            high--;
                        }
                    }
                }
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Three_Sum obj = new Three_Sum();
        int[] nums = { -1, 0, 1, 0 };
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);

    }

}
