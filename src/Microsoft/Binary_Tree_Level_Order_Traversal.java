package Microsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root != null) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int queueSize = queue.size();
            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                queueSize--;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if (queueSize == 0) {
                    result.add(list);
                    list = new LinkedList<>();
                    queueSize = queue.size();
                }
            }

        }
        return result;

    }
}
