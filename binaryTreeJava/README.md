## 二叉树的基本操作 JAVA

* 二叉树数据结构

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```
* 数组创建二叉树

```java
public   TreeNode  createTree(int[] list,int start){
        if(list[start]=='#')
        {
            return  null;
        }
        TreeNode root=new TreeNode(list[start]);
        int lNode=start*2+1;
        int rNode=start*2+2;
        if (lNode>list.length-1){
            root.left=null;
        }else{
            root.left=createTree(list,lNode);
        }
        if (rNode > list.length -1) {
            root.right =null;
        }else{
            root.right = createTree(list, rNode);
        }

        return root;
    }
```
* 前序遍历（递归）
 
```java
    public  void preOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {
            System.out.print(T.val+" ");
            preOrderTraverse(T.left);
            preOrderTraverse(T.right);
        }
    }
```
* 中序遍历（递归）

```java
public  void midOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {

            midOrderTraverse(T.left);
            System.out.print(T.val+" ");
            midOrderTraverse(T.right);

        }
    }
```
* 后序遍历（递归）

```java
public  void postOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {

            postOrderTraverse(T.left);
            postOrderTraverse(T.right);
            System.out.print(T.val+" ");
        }
    }
```

*层次遍历 （借助栈实现）

```java
public   void printTreeNode(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            System.out.print(node.val+" ");
        }
    }
```
