package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {

    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inOrder(root);
        return result;

    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            result.add(root.val);
            inOrder(root.right);
        }
    }
}
