package General;

public class PathSum {

    boolean result = false;
    int maxDepth = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        checkSum(root, 0, targetSum);
        return result;
    }

    private void checkSum(TreeNode root, int pathSum, int targetSum) {
        if (root == null)
            return;
        checkSum(root.left, pathSum + root.val, targetSum);
        checkSum(root.right, pathSum + root.val, targetSum);
        if (root.left == null && root.right == null) {
            pathSum += root.val;
            if (pathSum == targetSum) {
                result = true;
                return;
            }
        }
    }

    private static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        return root;
    }

    public static void main(String[] args) {
        PathSum obj = new PathSum();
        TreeNode root = createTree();
        obj.hasPathSum(root, 22);
    }

}
