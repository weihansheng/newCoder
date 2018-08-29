# 剑指Offer61
## 二叉搜索树的第k小个节点
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

思路：

* 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
* 所以，按照中序遍历顺序找到第k个结点就是结果。
* 最简单的是遍历所有节点并保存到数组中，第k个即为所求。但实际上无需遍历二叉树的所有节点，只需遍历k次就可以



```java
//二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    //所以，按照中序遍历顺序找到第k个结点就是结果。
    // 最简单的是遍历所有节点并保存到数组中，第k个即为所求。但实际上无需遍历二叉树的所有节点，只需遍历k次就可以，
    int index=0; //记录遍历了几个节点
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot!=null){
            //在左子树中找
            TreeNode node=KthNode(pRoot.left,k);
            //node不为空时代表找到了
            if (node!=null){
                return node;
            }
            index++;
            if (index==k)
            {
                return pRoot;
            }
            //在右子树中找
            node=KthNode(pRoot.right,k);
            //node不为空时代表找到了
            if (node!=null){
                return node;
            }

        }
        return null;
    }


```
