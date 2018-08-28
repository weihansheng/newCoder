import java.util.*;
public class Solution59 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (pRoot==null)
            return result;
        q.add(pRoot);
        while (q.size()>0){
            int size=q.size();
            ArrayList<Integer> r=new ArrayList<>();
            while (size>0){
                TreeNode node=q.remove();
                r.add(node.val);
                size-=1;
                if (node.left!=null)
                    q.add(node.left);
                if (node.right!=null)
                    q.add(node.right);

            }
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution59 solution59=new Solution59();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        node4.right=node6;
        System.out.println(solution59.Print(node1));
    }
}
