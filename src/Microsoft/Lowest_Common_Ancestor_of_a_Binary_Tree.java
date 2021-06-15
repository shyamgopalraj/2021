package Microsoft;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;

    }

}
