package General;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise)
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
