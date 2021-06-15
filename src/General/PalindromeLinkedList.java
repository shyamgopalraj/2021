package General;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

        if (head == null)
            return true;

        ListNode mid = getmid(head);
        ListNode secondHalfReverse = reverse(mid.next);
        display(head);

        ListNode secondHalf = secondHalfReverse;
        ListNode cur = head;

        while (secondHalf != null) {
            if (secondHalf.val != cur.val)
                return false;
            secondHalf = secondHalf.next;
            cur = cur.next;
        }

        mid.next = reverse(secondHalfReverse);
        display(head);
        return true;

    }

    public static void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {

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

    public static ListNode getmid(ListNode head) {

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        return tortoise;
    }

    public static ListNode createList(int[] nums) {
        ListNode cur = null;
        ListNode head = null;

        for (int num : nums) {
            if (head == null) {
                head = new ListNode(num);
                cur = head;
            } else {
                cur.next = new ListNode(num);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1 };
        ListNode head = createList(nums);
        display(head);
        isPalindrome(head);
    }

}
