package General;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    int[] preorder;
    int preOrderIndex;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        preOrderIndex = 0;
        map = new HashMap<>();

        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }

        return helper(0, preorder.length - 1);
    }

    private TreeNode helper(int left, int right) {

        if (left > right)
            return null;

        int rootval = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootval);

        int rootPosInOrder = map.get(rootval);
        preOrderIndex++;

        root.left = helper(left, rootPosInOrder - 1);
        root.right = helper(rootPosInOrder + 1, right);
        return root;

    }
}
