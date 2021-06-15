package General;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    List<Integer> preorderTraversal = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return preorderTraversal;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            preorderTraversal.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
