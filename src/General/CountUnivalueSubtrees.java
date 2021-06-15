package General;

public class CountUnivalueSubtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        findUnivalNodes(root);
        return count;
    }

    private boolean findUnivalNodes(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        boolean isUniVal = true;
        if (root.left != null) {
            isUniVal = findUnivalNodes(root.left) && isUniVal && (root.val == root.left.val);
        }

        if (root.right != null) {
            isUniVal = findUnivalNodes(root.right) && isUniVal && (root.val == root.right.val);
        }

        if (isUniVal) {
            count++;
            return true;
        }
        return false;
    }

}
