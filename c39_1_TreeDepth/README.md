# 剑指Offer39_1
## 二叉树的深度
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

思路：

     如果根结点只有左子树，那么树的深度就是左子树的深度+1
     如果根结点只有右子树，那么树的深度就是右子树的深度+1
     如果根结点有左子树和右子树，那么树的深度就是 Max(左子树的深度,右子树的深度)+1



注意：

```java
    public int TreeDepth(TreeNode pRoot){
        if (pRoot==null)
            return 0;
        int left=TreeDepth(pRoot.left);
        int right=TreeDepth(pRoot.right);
        return left>right?left+1:right+1;

    }

```
