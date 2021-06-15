package General;

public class MaximumDepthOfBinaryTree {

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        findMaxDepth(0, root);
        return maxDepth + 1;
    }

    private void findMaxDepth(int depth, TreeNode root) {
        if (root == null)
            return;
        findMaxDepth(depth + 1, root.left);
        findMaxDepth(depth + 1, root.right);
        maxDepth = Math.max(depth, maxDepth);
    }
}
