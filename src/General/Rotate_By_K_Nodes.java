package General;

public class Rotate_By_K_Nodes {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return head;

        int n = 1;
        ListNode oldTail;

        for (oldTail = head; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        k = k % n;
        ListNode newTail = head;
        for (int i = 1; i <= n - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }

    public static void main(String[] args) {

    }

}
