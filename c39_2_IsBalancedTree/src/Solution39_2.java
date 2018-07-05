public class Solution39_2 {
    public static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.value = val;
        }
        public TreeNode() {
        }
    };

    /**
     *
     如果递归遍历每个节点是不是平衡二叉树，在遍历结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
     如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度，
     如果发现子树不是平衡二叉树，则直接停止遍历，返回-1，这样至多只对每个结点访问一次。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        return isBlancedTreeCore(root)!=-1;
    }
    public int isBlancedTreeCore(TreeNode pRoot){
        if (pRoot==null) {
            return 0;
        }
        int left=isBlancedTreeCore(pRoot.left);
        if (left==-1){
            return -1;
        }
        int right=isBlancedTreeCore(pRoot.right);
        if (right==-1){
            return -1;
        }
        int diff=Math.abs(left-right);
        return diff>1?-1:Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;
        node4.left=node6;
//        node6.left=node7;

        Solution39_2 solution=new Solution39_2();
        System.out.println(solution.IsBalanced_Solution(root));

    }
}
