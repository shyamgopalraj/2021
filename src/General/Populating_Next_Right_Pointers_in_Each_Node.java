package General;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    Node node = queue.poll();
                    size--;
                    if (size == 0) {
                        node.next = null;
                    } else {
                        node.next = queue.peek();
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }

        return root;

    }

}
