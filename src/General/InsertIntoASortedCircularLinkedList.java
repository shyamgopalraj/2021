package General;

public class InsertIntoASortedCircularLinkedList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node prev = head;
        Node cur = prev.next;
        boolean insert = false;

        do {
            // val >= prev and val <= cur
            if (insertVal >= prev.val && insertVal <= cur.val) {
                insert = true;
            } else {
                if (prev.val > cur.val) {
                    // val <= prev
                    if (prev.val <= insertVal || insertVal >= cur.val) {
                        insert = true;
                    }
                }
            }

            if (insert) {
                Node node = new Node(insertVal, cur);
                prev.next = node;
                return head;
            }

            prev = cur;
            cur = cur.next;

        } while (prev != head);

        Node node = new Node(insertVal, cur);
        prev.next = node;
        return head;
    }
}
