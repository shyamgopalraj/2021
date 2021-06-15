package General;

public class Search_in_a_Binary_Search_Tree {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val)
                return root;
            if (val > root.val)
                return searchBST(root.right, val);
            else
                return searchBST(root.left, val);
        }
        return null;

    }

    public static TreeNode createTree(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        insert(root, val);
        return root;
    }

    private static void insert(TreeNode root, int val) {
        if (val >= root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
        if (root.left == null) {
            root.left = new TreeNode(val);
            return;
        }
        insert(root.left, val);
    }

    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + ",");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 1, 3, 7 };
        TreeNode head = null;
        for (int num : nums) {
            head = createTree(head, num);
        }
        inOrder(head);
        TreeNode result = searchBST(head, 2);
        if (result != null)
            System.out.println(result.val);
        System.out.println("null");

    }

}
