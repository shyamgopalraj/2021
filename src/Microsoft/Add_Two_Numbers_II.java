package Microsoft;

public class Add_Two_Numbers_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode result = Sum(l1, l2);
            return reverse(result);
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = head;
        ListNode cur = head;
        while (prev != null && prev.next != null) {
            cur = prev.next;
            prev.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    int carry = 0;

    private ListNode Sum(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode dummyHead = cur;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            cur = addNodeAndReturnCurPos(sum, cur);
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            cur = addNodeAndReturnCurPos(sum, cur);
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            cur = addNodeAndReturnCurPos(sum, cur);
            l2 = l2.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private ListNode addNodeAndReturnCurPos(int sum, ListNode cur) {
        if (sum >= 10) {
            carry = 1;
            cur.next = new ListNode(sum % 10);
        } else {
            carry = 0;
            cur.next = new ListNode(sum);
        }
        cur = cur.next;
        return cur;
    }

    public ListNode createListNode(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        return head;
    }

    public void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Add_Two_Numbers_II obj = new Add_Two_Numbers_II();
        int[] l1data = { 7, 2, 4, 3 };
        int[] l2data = { 5, 6, 4 };

        ListNode l1 = null;
        ListNode l2 = null;

        for (int num : l1data) {
            l1 = obj.createListNode(l1, num);
        }

        for (int num : l2data) {
            l2 = obj.createListNode(l2, num);
        }

        obj.display(l1);
        obj.display(l2);

        ListNode result = obj.addTwoNumbers(l1, l2);
        obj.display(result);

    }

}
