import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public   TreeNode  createTree(int[] list,int start){
        if(list[start]=='#')
        {
            return  null;
        }
        TreeNode root=new TreeNode(list[start]);
        int lNode=start*2+1;
        int rNode=start*2+2;
        if (lNode>list.length-1){
            root.left=null;
        }else{
            root.left=createTree(list,lNode);
        }
        if (rNode > list.length -1) {
            root.right =null;
        }else{
            root.right = createTree(list, rNode);
        }

        return root;
    }
    /**
     * 先序遍历函数
     **/
    public  void preOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {
            System.out.print(T.val+" ");
            preOrderTraverse(T.left);
            preOrderTraverse(T.right);
        }
    }
    /**
     *中序遍历函数
     **/
    public  void midOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {

            midOrderTraverse(T.left);
            System.out.print(T.val+" ");
            midOrderTraverse(T.right);

        }
    }
    /**
     * 后序遍历函数
     */

    public  void postOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {

            postOrderTraverse(T.left);
            postOrderTraverse(T.right);
            System.out.print(T.val+" ");
        }
    }

    /**
     * 层次遍历打印二叉树
     * @param root 根节点
     *
     *
     */
    public   void printTreeNode(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            System.out.print(node.val+" ");
        }
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn) {
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i = startIn; i <=endIn ; i++) {
            if (pre[startPre]==in[i]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }

        }
        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,pre.length-1);
        return root;
    }


}
