# 剑指Offer 59
## 把二叉树打印成行
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。


思路：
    
    使用队列进行层次遍历

```java
ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (pRoot==null)
            return result;
        q.add(pRoot);
        while (q.size()>0){
            int size=q.size();
            ArrayList<Integer> r=new ArrayList<>();
            while (size>0){
                TreeNode node=q.remove();
                r.add(node.val);
                size-=1;
                if (node.left!=null)
                    q.add(node.left);
                if (node.right!=null)
                    q.add(node.right);

            }
            result.add(r);
        }
        return result;
    }

```
