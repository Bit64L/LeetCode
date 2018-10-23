import common.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length)
            return null;
        return helper(0,0,inorder.length,preorder,inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart >= inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; inStart < inEnd; i++) {
            if (node.val == inorder[i]) {
                index = i;
                break;
            }
        }
        node.left = helper(preStart + 1, inStart, index, preorder, inorder);
        node.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return node;

    }

}
