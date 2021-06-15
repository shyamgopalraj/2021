package General;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        //This add the very first node of k nodes
        for (ListNode listNode : lists) {
            //Condition not add null node
            if (listNode != null)
                priorityQueue.add(listNode);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            cur.next = node;
            cur = cur.next;

            //Adding remaining node connected to given node.
            if (cur.next != null) {
                priorityQueue.add(cur.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
