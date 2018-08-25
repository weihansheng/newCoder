# 剑指Offer57
## 对称的二叉树

请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

思路：

首先根节点以及其左右子树，判断左子树的左子树和右子树的右子树是否相同
    左子树的右子树和右子树的左子树是否相同即可，
    
采用递归非递归也可，采用栈或队列存取各级子树根节点



注意：

```java
/*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
    * 左子树的右子树和右子树的左子树相同即可，采用递归
    * 非递归也可，采用栈或队列存取各级子树根节点
    */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null) {
            return true;
        }
        return compareCild(pRoot.left,pRoot.right);

    }
    boolean compareCild(TreeNode left,TreeNode right){
//        如果左孩子为空
        if (left==null) {
            return right == null?true:false;
        }
//        如果左孩子不为空，右孩子不为空
        if (right==null){
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
//        左孩子和右孩子都不为空
        return compareCild(left.left,right.right) && compareCild(left.right,right.left);
    }

```
