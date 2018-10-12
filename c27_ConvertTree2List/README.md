# 剑指Offer27
## 二叉搜索树转换为双向链表 
题目描述

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

思路：

首先需要明白二叉搜索树也是一种排序的数据结构，它的中序遍历就是一个不递减的顺序排列

所以如果要转换成一个排序好的双向链表，那么仅需要改变原来指向左子节点和右子节点的指针，让他们分别指向前节点和后节点即可


[Reference](https://www.cnblogs.com/keedor/p/4467040.html)

利用中序遍历

1.将左子树构造成双链表，并返回链表头节点。

2.定位至左子树双链表最后一个节点。

3.如果左子树链表不为空的话，将当前root追加到左子树链表。

4.将右子树构造成双链表，并返回链表头节点。

5.如果右子树链表不为空的话，将该链表追加到root节点之后。

6.根据左子树链表是否为空确定返回的节点。





注意：

```java
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
