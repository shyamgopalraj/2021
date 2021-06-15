package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Serialize_and_Deserialize_Binary_Tree_Common_Ancestor_of_a_Binary_Tree {

    String s = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        serializeUsingPreOrder(root);
        return s;
    }

    private void serializeUsingPreOrder(TreeNode root) {
        if(root == null){
            s += "null,";
            return;
        }
        s += Integer.toString(root.val)+",";
        serializeUsingPreOrder(root.left);
        serializeUsingPreOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sArray = data.split(",");
        List<String> sList = new ArrayList<>(Arrays.asList(sArray));
        return createTree(sList);
    }

    private TreeNode createTree(List<String> sList) {
        String val = sList.get(0);
        if(val.equals("null")){
            sList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        sList.remove(0);
        root.left = createTree(sList);
        root.right = createTree(sList);
        return root;
    }

}
