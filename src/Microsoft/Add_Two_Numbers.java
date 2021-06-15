package Microsoft;

public class Add_Two_Numbers {

    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int sum = 0;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            sum = val1 + val2 + carry;

            cur = addNode(sum, cur);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            cur = addNode(sum, cur);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            cur = addNode(sum, cur);
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;

    }

    private ListNode addNode(int sum, ListNode cur) {
        if (sum >= 10) {
            carry = 1;
            cur.next = new ListNode(sum % 10);
        } else {
            carry = 0;
            cur.next = new ListNode(sum);
        }
        return cur;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
