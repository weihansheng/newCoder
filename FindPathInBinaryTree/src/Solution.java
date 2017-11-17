import java.util.ArrayList;
import java.util.Stack;

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
     * 非递归
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPathNoRecursion(TreeNode root, int target) {
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
                    if (lastNode!=null&&(lastNode.right==null||lastNode.right==treeNode)){
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

    //递归版本
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
        {
            return null;
        }
        list.add(root.val);
        target=target-root.val;
        if (target==0&&root.right==null&&root.left==null){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        list.remove(list.size()-1);

        return result;
    }
    public  static void main(String[] args){

        int[] datanum = {1,2,3,2,1,5,6};
        //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
        Solution solution=new Solution();
        TreeNode root;
        root = solution.createTree(datanum, 0);

        //ArrayList<ArrayList<Integer>> result=solution.FindPath(root,6);
        ArrayList<ArrayList<Integer>> result=solution.FindPathNoRecursion(root,4);
        System.out.println(result.toString());
    }
}
