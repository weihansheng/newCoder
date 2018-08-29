import java.util.ArrayList;

public class Solution61 {
    static public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

//    TreeNode KthNode(TreeNode pRoot, int k)
//    {
//        ArrayList<TreeNode> arrayList=new ArrayList<>();
//        midOrder(pRoot,arrayList);
//        if (k<0||k>arrayList.size())
//        {
//            return null;
//        }
//        return arrayList.get(k-1);
//
//    }
//
//    void midOrder(TreeNode node,ArrayList<TreeNode> arrayList){
//        if (node==null) {
//            return ;
//        }
//        midOrder(node.left,arrayList);
//        arrayList.add(node);
//        midOrder(node.right,arrayList);
//    }
    //二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    //所以，按照中序遍历顺序找到第k个结点就是结果。
    // 最简单的是遍历所有节点并保存到数组中，第k个即为所求。但实际上无需遍历二叉树的所有节点，只需遍历k次就可以，
    int index=0; //记录遍历了几个节点
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot!=null){
            //在左子树中找
            TreeNode node=KthNode(pRoot.left,k);
            //node不为空时代表找到了
            if (node!=null){
                return node;
            }
            index++;
            if (index==k)
            {
                return pRoot;
            }
            //在右子树中找
            node=KthNode(pRoot.right,k);
            //node不为空时代表找到了
            if (node!=null){
                return node;
            }

        }
        return null;
    }


    public static void main(String[] args) {
        Solution61 solution61=new Solution61();
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node5.left=node3;
        node3.left=node2;
        node3.right=node4;
        node5.right=node7;
        node7.right=node8;
        node7.left=node6;
        System.out.println(solution61.KthNode(node5,1).val);
    }
}
