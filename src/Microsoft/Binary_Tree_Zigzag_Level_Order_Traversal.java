package Microsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {

            Stack<TreeNode> leftTraversalStack = new Stack<>();
            Stack<TreeNode> rightTraversalStack = new Stack<>();
            leftTraversalStack.push(root);
            List<Integer> list = new LinkedList<>();
            while (!leftTraversalStack.isEmpty() || !rightTraversalStack.isEmpty()) {
                while (!leftTraversalStack.isEmpty()) {
                    TreeNode treeNode = leftTraversalStack.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        rightTraversalStack.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        rightTraversalStack.push(treeNode.right);
                    }
                    if (leftTraversalStack.isEmpty()) {
                        result.add(list);
                        list = new LinkedList<>();
                    }
                }

                while (!rightTraversalStack.isEmpty()) {
                    TreeNode treeNode = rightTraversalStack.pop();
                    list.add(treeNode.val);
                    if (treeNode.right != null) {
                        leftTraversalStack.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        leftTraversalStack.push(treeNode.left);
                    }
                    if (rightTraversalStack.isEmpty()) {
                        result.add(list);
                        list = new LinkedList<>();
                    }
                }
            }
        }
        return result;

    }

}
