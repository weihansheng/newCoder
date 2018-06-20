# 剑指Offer25
## 二叉树中和为某一值的路径
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思路：

用前序遍历访问到某节点时，把该节点加到路径中。如果该节点是叶子节点并且路径中的和正好等于输入整数，则把当前路径符合要求

注意：可能有多条路径

```java
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

```
