package Microsoft;

public class Merge_Two_Sorted_List_Descending_Order {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = null;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                ListNode temp = l1.next;
                l1.next = result;
                result = l1;
                l1 = temp;
            } else {
                ListNode temp = l2.next;
                l2.next = result;
                result = l2;
                l2 = temp;
            }

        }

        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = result;
            result = l1;
            l1 = temp;
        }

        if (l2 != null) {
            ListNode temp = l2.next;
            l2.next = result;
            result = l2;
            l2 = temp;
        }

        return result;

    }

    public ListNode createList(int val, ListNode head) {
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
        Merge_Two_Sorted_List_Descending_Order obj = new Merge_Two_Sorted_List_Descending_Order();
        ListNode l1 = null;
        ListNode l2 = null;
        int[] nums1 = { 2, 5, 9 };
        int[] nums2 = { 3, 6, 9 };
        for (int num : nums1) {
            l1 = obj.createList(num, l1);
        }

        obj.display(l1);

        for (int num : nums2) {
            l2 = obj.createList(num, l2);
        }

        obj.display(l2);

        ListNode mergedListNode = obj.mergeTwoLists(l1, l2);
        obj.display(mergedListNode);
    }
}
