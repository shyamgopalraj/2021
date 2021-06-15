package General;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return head;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode cur = dummyNode;

        int count = 0;

        while (count != n && cur.next != null) {
            cur = cur.next;
            count++;
        }

        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }

        prev.next = prev.next == null ? null : prev.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
