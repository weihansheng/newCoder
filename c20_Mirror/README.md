# 剑指Offer20
## 二叉树的镜像
操作给定的二叉树，将其变换为源二叉树的镜像。

思路：递归交换左右子树

注意：要考虑根结点为空，左右子树为空的情况

```java
 public void Mirror(TreeNode root) {
        if (root==null)
            return;
        if (root.left==null&&root.right==null)
            return ;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        if (root.left!=null)
            Mirror(root.left);
        if (root.right!=null)
            Mirror(root.right);

    }
```
