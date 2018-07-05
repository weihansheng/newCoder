# 剑指Offer39_2
## 判断平衡二叉树
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

思路：
    要做剪枝
    如果递归遍历每个节点左右子树的深度来判断该节点是不是平衡二叉树，在遍历结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
    如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度，
    如果发现子树不是平衡二叉树，则直接停止遍历，返回-1，这样至多只对每个结点访问一次。

注意：

```java
public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        return isBlancedTreeCore(root)!=-1;
    }
    public int isBlancedTreeCore(TreeNode pRoot){
        if (pRoot==null) {
            return 0;
        }
        int left=isBlancedTreeCore(pRoot.left);
        if (left==-1){
            return -1;
        }
        int right=isBlancedTreeCore(pRoot.right);
        if (right==-1){
            return -1;
        }
        int diff=Math.abs(left-right);
        return diff>1?-1:Math.max(left,right)+1;
    }

```
