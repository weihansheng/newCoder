public class Solution27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //last用于记录上一个节点
    TreeNode last=null;
    public  void ConvertHelper(TreeNode cur){
        if(cur==null){
            return;
        }
        ConvertHelper(cur.left);
//        当前节点的左节点是上一个节点
        cur.left=last;
        if (last!=null){
            last.right=cur;
        }
        last=cur;
        ConvertHelper(cur.right);
    }

    //    返回双链表头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ConvertHelper(pRootOfTree);

        TreeNode tmp=pRootOfTree;
        while(tmp.left!=null){
            tmp=tmp.left;
        }
        return tmp;
    }
}
