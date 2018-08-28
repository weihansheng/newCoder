import java.util.*;
public class Solution58 {
    static  public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 使用两个栈,s1存放奇数层,s2存放偶数层
     * 奇数层从前往后遍历,偶数层从后往前遍历
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        if (pRoot==null)
            return result;
        s1.add(pRoot);
        while (s1.size()>0||s2.size()>0){
            ArrayList<Integer> r1=new ArrayList<>();
            while (s1.size()>0){
                TreeNode node=s1.pop();
                r1.add(node.val);
                if (node.left!=null)
                    s2.add(node.left);
                if (node.right!=null)
                    s2.add(node.right);
            }
            if (r1.size()>0)
                result.add(r1);
            ArrayList<Integer> r2=new ArrayList<>();
            while (s2.size()>0){
                TreeNode node=s2.pop();
                r2.add(node.val);
                if (node.right!=null)
                    s1.add(node.right);
                if (node.left!=null)
                    s1.add(node.left);
            }
            if (r2.size()>0)
                result.add(r2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution58 solution58=new Solution58();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node7;
        node3.left=node6;
        node6.left=node8;
        System.out.println(solution58.Print(node1));
    }
}
