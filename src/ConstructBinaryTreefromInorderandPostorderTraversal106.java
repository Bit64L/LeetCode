import common.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)
            return null;
        return helper(postorder.length-1,0,inorder.length,inorder,postorder);
    }
    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder){

        if(postEnd<0 || inStart>=inEnd)
            return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = 0;
        for(int i=inStart;i<inEnd;i++){
            if(inorder[i] == node.val){
                index = i;
                break;
            }

        }
        node.left = helper(postEnd-(inEnd - index), inStart, index,inorder,postorder);
        node.right = helper(postEnd-1,index+1, inEnd,inorder,postorder);
        return node;
    }
}
