import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode createTree(int[] list, int start){
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

    /**
     * 判断root2是否为root1的子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2){
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2==null){
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1==null)
        {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (root1.val!=root2.val){
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right,root2.right);
    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1!=null&&root2!=null){
            //如果找到了对应Tree2的根节点的点
            if(root1.val==root2.val){
                result=doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result){
                result=HasSubtree(root1.left,root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result){
                result=HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }


}
