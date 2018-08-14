# 剑指Offer 56
## 二叉树的下一个结点
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。


思路：

* 思路1:先写一个中序遍历的算法。关键是从根节点开始遍历，所以第一步还是找到某个节点的根节点，方法是一直使用next判断即可。
   再将从根节点中序遍历的结果保存到一个数组中，直接找pNode所在索引的下一个即可。当然要考虑这个节点是不是最后一个，如果是最后一个，直接返回None。
* 思路2:分析二叉树的下一个节点，一共有以下情况：
     * 1.二叉树为空，则返回空；
     * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。  
注意：

```java
//思路1
static public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    
    List<TreeLinkNode> list=new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode cur=pNode;
        TreeLinkNode root=pNode;
        while (pNode.next!=null){
            pNode=pNode.next;
            root=pNode;
        }
        MidOrderTraverse(root);
        TreeLinkNode target=null;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i)==cur){
                if (i<list.size()-1)
                    target= list.get(i+1);
                else
                    target =null;
                break;
            }
        }
        return target;
    }
    //中序遍历函数
    void MidOrderTraverse(TreeLinkNode node)
    {
        if(node!=null)
        {
            MidOrderTraverse(node.left);
            list.add(node);
            MidOrderTraverse(node.right);
        }
        return;
    }
    //思路2
        TreeLinkNode GetNext2(TreeLinkNode node)
        {
            if(node==null) return null;
            if(node.right!=null){    //如果有右子树，则找右子树的最左节点
                node = node.right;
                while(node.left!=null) node = node.left;
                return node;
            }
            while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
                if(node.next.left==node) return node.next;
                node = node.next;
            }
            return null;   //退到了根节点仍没找到，则返回null
        }

```
