# newCoder
### 二叉搜索树与双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

```java
/**
思路（递归）
跟前序遍历思路相似
需要一个全局变量记录上个结点
遍历左子树
当前结点指向左指针指向前驱结点
前驱结点右指针指向当前结点
前驱 = 当前结点
遍历右子树

最后返回双向链表的最左边的结点
**/
public class Solution {
    //last用于记录上一个节点
    TreeNode last=null;
    public  void ConvertHelper(TreeNode cur){
        if(cur==null){
            return;
        }
        ConvertHelper(cur.left);
//        当前节点的左节点是上一个节点
        cur.left=last;
        if (last!=null){
            last.right=cur;
        }
        last=cur;
        ConvertHelper(cur.right);
    }

//    返回双链表头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ConvertHelper(pRootOfTree);

        TreeNode tmp=pRootOfTree;
        while(tmp.left!=null){
            tmp=tmp.left;
        }
        return tmp;
    }
```
