import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution25 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //从根结点开始进行前序遍历 如果该节点是叶节点并且路径中的元素的和等于目标值 则为一个目标路径
    static public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> result1=new ArrayList<>();
        if (root==null)
        {
            return result;
        }
        int currentSum=0;
        FindPathChild(root,target,currentSum,result1,result);
        return result;
    }
    public static void FindPathChild(TreeNode root, int expectSum, int currentSum, ArrayList<Integer> arrayList,ArrayList<ArrayList<Integer>> result){
        boolean isLeaf=root.left==null&&root.right==null;
        currentSum=currentSum+root.val;
        arrayList.add(root.val);
        if (currentSum==expectSum&&isLeaf){
            ArrayList<Integer> arrayTmp=new ArrayList<>();
            arrayTmp=(ArrayList<Integer>)arrayList.clone();
            result.add(arrayTmp);
        }
        if (root.left!=null){
            FindPathChild(root.left,expectSum,currentSum,arrayList,result);
        }
        if (root.right!=null){
            FindPathChild(root.right,expectSum,currentSum,arrayList,result);
        }
        currentSum=currentSum-root.val;
        arrayList.remove(arrayList.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(10);
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        TreeNode node12=new TreeNode(12);
        node1.left=node5;
        node1.right=node12;
        node5.left=node4;
        node5.right=node7;
        ArrayList<ArrayList<Integer>> r=FindPath(node1,19);
        System.out.println(r.toString());

    }

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (root==null)
        {
            return result;
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode lastNode=null;
        stack.push(root);
        int sum=0;
        while(!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            if (sum+treeNode.val<=target){
                arrayList.add(treeNode.val);
                sum=sum+treeNode.val;
                if (sum==target&&treeNode.left==null&&treeNode.right==null){
                    ArrayList<Integer> arrayTmp=new ArrayList<>();
                    arrayTmp=(ArrayList<Integer>)arrayList.clone();
                    result.add(arrayTmp);
                    arrayList.remove(arrayList.size()-1);
                    sum=sum-treeNode.val;
                    if (lastNode!=null&&lastNode.right==treeNode){
                        sum=sum-lastNode.val;
                        arrayList.remove(arrayList.size()-1);

                    }
                    continue;
                }
                //若没有子节点则清除该节点
                if(treeNode.right==null&&treeNode.left==null) {
                    sum = sum - treeNode.val;
                    arrayList.remove(arrayList.size() - 1);
                }else {
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                        lastNode = treeNode;
                    }
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                        lastNode = treeNode;
                    }
                }
            }
//            if (lastNode!=null&&(lastNode.right==null||lastNode.right==treeNode)){
//                    sum=sum-lastNode.val;
//
//            }

        }
        return result;

    }
}
