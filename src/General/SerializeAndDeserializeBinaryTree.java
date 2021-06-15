package General;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    public String serializeUsingPreOrderTraversal(TreeNode root, String serializedString) {
        if (root == null) {
            serializedString += "null,";
        } else {
            serializedString += String.valueOf(root.val) + ",";
            serializedString = serializeUsingPreOrderTraversal(root.left, serializedString);
            serializedString = serializeUsingPreOrderTraversal(root.right, serializedString);
        }
        return serializedString;
    };

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeUsingPreOrderTraversal(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return recreateTreeFromString(data_list);
    }

    private TreeNode recreateTreeFromString(List<String> data_list) {
        if (data_list.get(0).equals("null")) {
            data_list.remove(0);
            return null;
        }
        String val = data_list.get(0);
        data_list.remove(0);
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = recreateTreeFromString(data_list);
        root.right = recreateTreeFromString(data_list);
        return root;
    }

    public static void main(String[] args) {
    }

}
