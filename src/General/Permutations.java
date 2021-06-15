package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
        }
        backTrack(nums.length, 0, numList, result);
        return result;
    }

    private void backTrack(int length, int first, List<Integer> numList, List<List<Integer>> result) {
        if (first == length) {
            result.add(new LinkedList<>(numList));
        }

        for (int i = first; i < length; i++) {
            Collections.swap(numList, first, i);
            backTrack(length, first + 1, numList, result);
            Collections.swap(numList, first, i);
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }

}
