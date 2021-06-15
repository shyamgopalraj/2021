package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        Node oldNode = head;
        Node newNode = null;

        while (oldNode != null) {

            if (!map.containsKey(oldNode)) {
                newNode = new Node(oldNode.val);
                map.put(oldNode, newNode);
            } else {
                newNode = map.get(oldNode);
            }

            cur.next = newNode;

            if (oldNode.next != null) {
                Node oldNodeNext = oldNode.next;
                if (!map.containsKey(oldNodeNext)) {
                    map.put(oldNodeNext, new Node(oldNodeNext.val));
                }
                newNode.next = map.get(oldNodeNext);
            }
            if (oldNode.random != null) {
                Node oldNodeRandom = oldNode.random;
                if (!map.containsKey(oldNodeRandom)) {
                    map.put(oldNodeRandom, new Node(oldNodeRandom.val));
                }
                newNode.random = map.get(oldNodeRandom);
            }
            oldNode = oldNode.next;
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
