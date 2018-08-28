# 剑指Offer 58
## 按之字形打印二叉树
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。


思路：

    使用两个栈,s1存放奇数层,s2存放偶数层
    奇数层从前往后遍历,偶数层从后往前遍历
    

```java

    /**
     * 使用两个栈,s1存放奇数层,s2存放偶数层
     * 奇数层从前往后遍历,偶数层从后往前遍历
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        if (pRoot==null)
            return result;
        s1.add(pRoot);
        while (s1.size()>0||s2.size()>0){
            ArrayList<Integer> r1=new ArrayList<>();
            while (s1.size()>0){
                TreeNode node=s1.pop();
                r1.add(node.val);
                if (node.left!=null)
                    s2.add(node.left);
                if (node.right!=null)
                    s2.add(node.right);
            }
            if (r1.size()>0)
                result.add(r1);
            ArrayList<Integer> r2=new ArrayList<>();
            while (s2.size()>0){
                TreeNode node=s2.pop();
                r2.add(node.val);
                if (node.right!=null)
                    s1.add(node.right);
                if (node.left!=null)
                    s1.add(node.left);
            }
            if (r2.size()>0)
                result.add(r2);
        }
        return result;
    }

```
