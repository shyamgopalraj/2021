package General;

public class AddTwoNumbersInLinkedList {

    public ListNode createList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = cur;

        while (prev.next != null) {
            cur = prev.next;
            prev.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // When l1 and l2 is not empty
        int digit = 0;
        int carry = 0;
        int sum = 0;
        ListNode dummyResultHead = new ListNode(0);
        ListNode cur = dummyResultHead;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;

            if (sum > 9)
                carry = 1;
            else
                carry = 0;

            digit = sum % 10;
            cur.next = new ListNode(digit);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            if (sum > 9)
                carry = 1;
            else
                carry = 0;

            digit = sum % 10;
            cur.next = new ListNode(digit);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            if (sum > 9)
                carry = 1;
            else
                carry = 0;

            digit = sum % 10;
            cur.next = new ListNode(digit);
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry == 1)
            cur.next = new ListNode(carry);

        return dummyResultHead.next;
    }

    public static void main(String[] args) {
        int[] a = { 2, 4, 3 };
        int[] b = { 5, 6, 4 };
        AddTwoNumbersInLinkedList addTwoNumbersInLinkedList = new AddTwoNumbersInLinkedList();
        ListNode l1 = addTwoNumbersInLinkedList.createList(a);
        addTwoNumbersInLinkedList.display(l1);
        ListNode l2 = addTwoNumbersInLinkedList.createList(b);
        addTwoNumbersInLinkedList.display(l2);
        ListNode result = addTwoNumbersInLinkedList.addTwoNumbers(l1, l2);
        addTwoNumbersInLinkedList.display(result);

    }

}
