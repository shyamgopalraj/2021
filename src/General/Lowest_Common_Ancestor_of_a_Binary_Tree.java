package General;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        solution(root, p, q);
        return result;

    }

    private boolean solution(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return false;

        int left = solution(root.left, p, q) ? 1 : 0;

        int right = solution(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if ((left + right + mid) >= 2) {
            this.result = root;
        }

        return (left + right + mid > 0);

    }
}
