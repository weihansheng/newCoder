public class Solution39_1 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    };

    /**
     *
     思路：
     如果根结点只有左子树，那么树的深度就是左子树的深度+1
     如果根结点只有右子树，那么树的深度就是右子树的深度+1
     如果根结点有左子树和右子树，那么树的深度就是 Max(左子树的深度,右子树的深度)+1
     */
    public int TreeDepth(TreeNode pRoot){
        if (pRoot==null)
            return 0;
        int left=TreeDepth(pRoot.left);
        int right=TreeDepth(pRoot.right);
        return left>right?left+1:right+1;

    }
}
