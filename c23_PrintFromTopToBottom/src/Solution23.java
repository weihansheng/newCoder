import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution23 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return result;
        }
        queue.add(root);
        TreeNode curNode=null;
        while (!queue.isEmpty()){
            curNode=queue.remove();
            result.add(curNode.val);
            if (curNode.left!=null)
            {
                queue.add(curNode.left);
            }
            if (curNode.right!=null)
            {
                queue.add(curNode.right);
            }
        }
        return result;

    }
}
