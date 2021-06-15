package General;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
