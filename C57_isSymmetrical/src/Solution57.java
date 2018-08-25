public class Solution57 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
    * 左子树的右子树和右子树的左子树相同即可，采用递归
    * 非递归也可，采用栈或队列存取各级子树根节点
    */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null) {
            return true;
        }
        return compareCild(pRoot.left,pRoot.right);

    }
    boolean compareCild(TreeNode left,TreeNode right){
//        如果左孩子为空
        if (left==null) {
            return right == null?true:false;
        }
//        如果左孩子不为空，右孩子不为空
        if (right==null){
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
//        左孩子和右孩子都不为空
        return compareCild(left.left,right.right) && compareCild(left.right,right.left);
    }


    public static void main(String[] args) {

    }
}
