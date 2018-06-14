# 剑指Offer23
## 从上往下打印二叉树
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

思路：使用辅助队列，每一次打印一个节点的时候，如果有子节点，则把左右子节点依次加到辅助队列的尾端，每次从队列头取出一个节点重复以上步骤 直到队列为空。

注意：

```java
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return result;
        }
        queue.add(root);
        TreeNode curNode=null;
        while (!queue.isEmpty()){
            curNode=queue.remove();
            result.add(curNode.val);
            if (curNode.left!=null)
            {
                queue.add(curNode.left);
            }
            if (curNode.right!=null)
            {
                queue.add(curNode.right);
            }
        }
        return result;

    }__
```
