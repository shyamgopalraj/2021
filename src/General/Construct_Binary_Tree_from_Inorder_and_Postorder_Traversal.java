package General;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    Map<Integer, Integer> mapInorder;
    int[] postOrder;
    int postValIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        mapInorder = new HashMap<Integer, Integer>();
        this.postOrder = postorder;
        this.postValIndex = postOrder.length - 1;

        for (int index = 0; index < inorder.length; index++) {
            mapInorder.put(inorder[index], index);
        }

        return helper(0, postorder.length - 1);

    }

    private TreeNode helper(int left, int right) {

        if (left > right) {
            return null;
        }

        int rootval = postOrder[postValIndex];
        TreeNode root = new TreeNode(rootval);

        int rootPosInOrder = mapInorder.get(rootval);

        postValIndex--;

        root.right = helper(rootPosInOrder + 1, right);
        root.left = helper(left, rootPosInOrder - 1);
        return root;
    }

}
