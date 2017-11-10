import java.util.ArrayList;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            result.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null)
            {
                queue.offer(node.right);
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] datanum = {1,2,3,4,5,'#',6,'#','#',7,8};
        //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
        Solution solution=new Solution();
        TreeNode root;
        root = solution.createTree(datanum, 0);
        ArrayList<Integer> result=new ArrayList<>();
        result=solution.PrintFromTopToBottom(root);
        System.out.println(result.toString());
    }
}
