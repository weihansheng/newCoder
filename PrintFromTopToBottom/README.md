# newCoder
## 从上往下打印二叉树

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

思路：
二叉树的层次遍历，借助一个队列就可以了。

``` java
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        if (root==null){
            return result;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            result.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null)
            {
                queue.offer(node.right);
            }
        }
        return result;
    }
```