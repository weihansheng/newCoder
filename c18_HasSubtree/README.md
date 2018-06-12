# 剑指Offer18
## 树的子结构
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

思路：

第一步：在树A中查找与B的根结点的值一样的结点R，实际就是输的遍历，用遍历实现

第二部：判断树A中以R为根结点的子树是不是和数B具有相同的结构

```java
public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2==null)
            return true;
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1==null)
            return false;
        //如果根节点对应的上，那么就分别去子节点里面匹配
        if (root1.val==root2.val){
            return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
        }else {
            //如果其中有一个点没有对应上，返回false
            return false;
        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1!=null&&root2!=null){
            //如果找到了对应Tree2的根节点的点
            if (root1.val==root2.val){
                result=DoesTree1HaveTree2(root1,root2);
            }
            if (!result){
                //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
                result=HasSubtree(root1.left,root2);
            }
            if (!result){
                //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
                result=HasSubtree(root1.right,root2);
            }

        }

        return result;
    }
```
