package General;

public class FlattenAMultilevelDoublyLinkedList {

    public class Node {
        Node prev;
        Node next;
        Node child;
        int val;
        
        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {

        if (head == null)
            return null;

        Node dummyHead = new Node(0);
        DFS(dummyHead, head);

        dummyHead.next.prev = null;
        return head;

    }

    private Node DFS(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }

        prev.next = cur;
        cur.prev = prev;

        Node curNext = cur.next;

        Node tail = DFS(cur, cur.child);
        cur.child = null;

        return DFS(tail, curNext);

    }

}
