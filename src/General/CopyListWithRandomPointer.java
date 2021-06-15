package General;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> map = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node oldHead = head;
        Node newHead = new Node(head.val);
        map.put(oldHead, newHead);
        while (oldHead != null) {
            newHead.next = getCloned(oldHead.next);
            newHead.random = getCloned(oldHead.random);

            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return map.get(head);
    }

    private Node getCloned(Node node) {
        if (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }
            return map.get(node);
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
