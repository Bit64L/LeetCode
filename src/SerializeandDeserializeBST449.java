import common.TreeNode;

public class SerializeandDeserializeBST449 {

}
class Codec1 {
    private final String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        res.append(root.val).append(SEP);
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        String[] strs = data.split(",");
        return deserializeHelper(strs, 0, strs.length-1);
    }
    public TreeNode deserializeHelper(String[] strs, int lo, int hi){
        if(lo > hi) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[lo]));
        int i;
        for(i=lo;i<=hi;i++)
            if(Integer.parseInt(strs[i]) > root.val) break;
        root.left = deserializeHelper(strs, lo+1,i-1);
        root.right = deserializeHelper(strs, i, hi);
        return root;
    }
}