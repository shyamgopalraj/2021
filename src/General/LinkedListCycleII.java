package General;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;

        ListNode intersection = getIntersection(head);

        if (intersection == null) {
            return null;
        }

        // Get start point of cycle

        ListNode cur = head;
        while (cur != intersection) {
            cur = cur.next;
            intersection = intersection.next;
        }

        return cur;

    }

    private ListNode getIntersection(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise)
                return hare;
        }

        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
