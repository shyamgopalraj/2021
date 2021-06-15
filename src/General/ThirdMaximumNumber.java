package General;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i : nums)
            priorityQueue.add(i);

        int max = priorityQueue.peek();
        int lastPopped = max;
        int count = 1;

        while (count != 3 && !priorityQueue.isEmpty()) {
            if (priorityQueue.peek() != lastPopped) {
                count++;
                lastPopped = priorityQueue.peek();
            }
            priorityQueue.poll();
        }

        return count == 3 ? lastPopped : max;
    }

    // Using set
    public int usingSet(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }

        return set.size() == 3 ? Collections.min(set) : Collections.max(set);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
