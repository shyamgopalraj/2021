package General;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {

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

    public static ListNode reverseListRecursive(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static ListNode createList(){
        ListNode head =  null;
        ListNode cur = null;

        for(int i=1;i<=3;i++){
            if(head == null){
                head = new ListNode(i);
                cur = head;
            }
            else{
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void display(ListNode head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = createList();
        display(head);
        ListNode node = reverseListRecursive(head);
    }

}
