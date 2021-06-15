package Microsoft;

public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return head;

        ListNode prev = head;
        ListNode cur = head;

        while (prev.next != null) {
            cur = prev.next;
            prev.next = cur.next;
            cur.next = head;
            head = cur;
        }

        return head;
    }

    private ListNode createList(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
        return head;

    }

    public static void main(String[] args) {
        Reverse_Linked_List obj = new Reverse_Linked_List();
        int[] nums = { 1, 2, 3 };
        ListNode head = null;
        for (int num : nums) {
            head = obj.createList(head, num);
        }

    }

}
