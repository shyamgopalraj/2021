package General;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static List<TreeNode> generate_trees(int start, int end) {

        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {

            if(start == 1 && i==2) {
                System.out.println("start == 1 and i == 2");
            }
            List<TreeNode> leftSubTree = generate_trees(start, i - 1);
            List<TreeNode> rightSubTree = generate_trees(i + 1, end);

            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;

    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return generate_trees(1, n);
    }

    public static void main(String[] args) {
        generateTrees(3);
    }

}
