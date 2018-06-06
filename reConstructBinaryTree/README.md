# newCoder
## 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

思路：

1.先求出根节点root，即pre[startPre]

2.求出root的左右树的前序遍历和中序遍历

* 左子树的中序遍历为原中序遍历中pre[startPre]的左半部分，根据左子树的中序遍历可得到左子树的前序遍历

* 右子树的中序遍历为原中序遍历中pre[startPre]的右半部分。根据右子树的中序遍历可得到左子树的前序遍历

3.再对左右两部分重复1、2步，求出的

4.左右子树的前序序列第一个元素分别是根节点的左右儿子

5.重复以上步骤

```java
private TreeNode reConstructBinaryTreeCore(int [] pre,int [] in) {
        if(pre.length==0||in.length==0) {
            return null;
        }
        if(pre.length!=in.length){
            System.out.println("长度不一样。");
        }
        TreeNode root=new TreeNode(pre[0]);
        //找到根节点在in中的位置
        for (int i = 0; i <in.length ; i++) {
            if (pre[0]==in[i]){
                //递归构造左子树和右子树
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }

        }
        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTreeCore(pre,in);
        return root;
    }
```
