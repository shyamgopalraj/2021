package Microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            cur.next = listNode;
            cur = cur.next;

            if (cur.next != null) {
                priorityQueue.add(cur.next);
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
