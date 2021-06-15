package Microsoft;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return checkTreeBST(root, null, null);
    }

    private boolean checkTreeBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return (checkTreeBST(root.left, min, root.val) && checkTreeBST(root.right, root.val, max));
    }

    public void createBinaryTree(TreeNode head, int val) {
        if (val < head.val) {
            if (head.left == null) {
                head.left = new TreeNode(val);
            } else {
                createBinaryTree(head.left, val);
            }
        } else {
            if (head.right == null) {
                head.right = new TreeNode(val);
            } else {
                createBinaryTree(head.right, val);
            }
        }
    }

    public void inOrder(TreeNode head) {
        if (head != null) {
            inOrder(head.left);
            System.out.print(head.val + ",");
            inOrder(head.right);
        }
    }

    public static void main(String[] args) {
        Validate_Binary_Search_Tree obj = new Validate_Binary_Search_Tree();
        TreeNode head = new TreeNode(5);
        int[] nums = { 1, 4, 3, 6 };
        for (int num : nums) {
            obj.createBinaryTree(head, num);
        }
        System.out.println("InOrder Travsersal: ");
        obj.inOrder(head);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        if(obj.isValidBST(root)) {
            System.out.println("valid");
        }
        else {
            System.out.println("Invalid");
        }
    }

}
