package General;

public class Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node head = null;
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root != null) {
            inOrder(root);
            tail.right = head;
            head.left = tail;
        }
        return head;
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            createCirularList(root);
            inOrder(root.right);
        }
    }

    private void createCirularList(Node root) {
        if (head == null) {
            head = root;
            tail = head;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
    }
}
