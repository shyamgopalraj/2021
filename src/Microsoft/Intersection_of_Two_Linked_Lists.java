package Microsoft;

public class Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {

            if (curA == null) {
                curA = headB;
                curB = curB.next;
            } else if (curB == null) {
                curB = headA;
                curA = curA.next;

            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        if (curA == null) {
            return null;
        }
        return curA;
    }

    public static void main(String[] args) {

    }

}
