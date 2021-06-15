package General;

public class OddEvenLinkedList {
    

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode oddhead = head;
        ListNode oddtail = oddhead;
        ListNode evenhead = null;
        ListNode eventail = evenhead;
        int index = 1;

        while (cur.next != null) {

            cur = cur.next;
            index++;

            if (index % 2 == 0) {
                if (evenhead == null) {
                    evenhead = cur;
                    eventail = evenhead;
                } else {
                    eventail.next = cur;
                    eventail = cur;
                }
            } else {
                oddtail.next = cur;
                oddtail = cur;
            }

        }

        oddtail.next = evenhead;
        eventail.next = null;
        return oddhead;

    }
    
    public static ListNode createList() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2;i<=5;i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }
    
    public static void display(ListNode head) {
        while(head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ListNode head = createList();
        display(head);
        ListNode result = oddEvenList(head);
        display(head);
    }

}
