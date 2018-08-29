# 剑指Offer60
## 序列化二叉树
题目描述

请实现两个函数，分别用来序列化和反序列化二叉树

思路：

* 序列化二叉树时，根据前序遍历方式将二叉树节点的值转换为字符串，如果二叉树节点为空，则以‘#’代替，每个节点的值以‘，’分隔，
* 反序列化时，以前序遍历方式从队列中取出数值构建二叉树


```java
/**
     * 序列化二叉树时，根据前序遍历方式将二叉树节点的值转换为字符串，如果二叉树节点为空，则以‘#’代替，每个节点的值以‘，’分隔，
     * 反序列化时，以前序遍历方式从队列中取出数值构建二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuffer s=new StringBuffer();
        if (root==null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val);
        s.append(',');
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();

    }
    TreeNode Deserialize(String str) {
        if (str.equals("#")) {
            return null;
        }
        String[] arr=str.split(",");
        Queue<String> q=new LinkedList<>();
        for (String s:arr) {
            q.add(s);
        }
        TreeNode root=preOrder(q);
        return root;
    }
    TreeNode preOrder(Queue<String> q){
        String s=q.remove();
        if (s.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(s));
        node.left=preOrder(q);
        node.right=preOrder(q);
        return node;
    }


```
