import common.TreeLinkNode;
import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeII117 {
    public void connect1(TreeLinkNode root) {//失败，由于dfs的特点无法找到距离最近的右边结点
        if (root == null)
            return;
        if (root.left != null && root.right != null)
            root.left.next = root.right;
        TreeLinkNode curr = root.right != null ? root.right : root.left;
        TreeLinkNode next = root.next;
        while (curr != null && next != null) {
            if (next.left != null) {
                curr.next = next.left;
                break;
            }
            if (next.right != null) {
                curr.next = next.right;
                break;
            }
            next = next.next;
        }
        connect(root.left);
        connect(root.right);
    }
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode leveStart = root;
        while(leveStart!=null){
            TreeLinkNode curr = leveStart;
            while(curr!=null){
                if (curr.left != null && curr.right != null)
                    curr.left.next = curr.right;
                TreeLinkNode node = curr.right != null ? curr.right : curr.left;
                TreeLinkNode next = curr.next;
                while (node != null && next != null) {
                    if (next.left != null) {
                        node.next = next.left;
                        break;
                    }
                    if (next.right != null) {
                        node.next = next.right;
                        break;
                    }
                    next = next.next;
                }
                curr = curr.next;
            }
            leveStart = leveStart.left != null ? leveStart.left : leveStart.right;
        }
    }
    @Test
    public void test() {
        String vals = "-1,-7,9,#,#,-1,-7,#,8,-9";
        String[] strs = vals.split(",");
        TreeLinkNode root = helper(1,strs);
        connect(root);
        System.out.println();
    }

    public TreeLinkNode helper(int i, String[] strs){
        if(i>strs.length || strs[i-1].equals("#")){
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(Integer.parseInt(strs[i - 1]));
        root.left = helper(2*i,strs);
        root.right = helper(2*i+1, strs);
        return root;
    }
}
