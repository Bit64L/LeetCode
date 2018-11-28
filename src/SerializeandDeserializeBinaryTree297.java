import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SerializeandDeserializeBinaryTree297 {

}
class Codec11 {
    private final String SEP=",";
    private final String NULL="X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if(root == null)
            return res.append(NULL).append(SEP).toString();
        res.append(root.val).append(SEP);
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("X,")) return null;
        Stack<TreeNode> stack = new Stack<>();
        String[] strs = data.split(",");
        TreeNode parent = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode root = parent;
        for(int i=1;i<strs.length;i++){
            if(parent != null){
                stack.push(parent);
                parent.left = strs[i].equals("X")? null: new TreeNode(Integer.parseInt(strs[i]));
                parent = parent.left;
            }else{
                parent = stack.pop();
                parent.right = strs[i].equals("X")? null: new TreeNode(Integer.parseInt(strs[i]));
                parent = parent.right;
            }
        }
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return deserializeHelper(list);
    }
    public TreeNode deserializeHelper(List<String> list){
        if(list.get(0).equals("X")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
    }
}