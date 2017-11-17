# newCoder
### 二叉树中和为某一值的路径
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思路：

* 先进栈，出站时判断 如果和是否<=target，加入路径的数组中
* 如果和=target且是叶子节点，则把本条路径加到结果集中
* 如果本叶子节点是上个节点的右子节点 则回退到上个节点 进行下一条路径的查找

```java
/**
     * 非递归
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPathNoRecursion(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNode = null;
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (sum + treeNode.val <= target) {
                arrayList.add(treeNode.val);
                sum = sum + treeNode.val;
                if (sum == target && treeNode.left == null && treeNode.right == null) {
                    ArrayList<Integer> arrayTmp = new ArrayList<>();
                    arrayTmp = (ArrayList<Integer>) arrayList.clone();
                    result.add(arrayTmp);
                    arrayList.remove(arrayList.size() - 1);
                    sum = sum - treeNode.val;
                    //如果本叶子节点是上个节点的右子节点 则回退到上个节点 进行下一条路径的查找
                    if (lastNode!=null&&lastNode.right == treeNode) {
                        sum = sum - lastNode.val;
                        arrayList.remove(arrayList.size() - 1);
                    }
                    continue;
                }
                //若没有子节点则清除该节点
                if (treeNode.right == null && treeNode.left == null) {
                    sum = sum - treeNode.val;
                    arrayList.remove(arrayList.size() - 1);
                } else {
                    if (treeNode.right != null) {
                        stack.push(treeNode.right);
                        lastNode = treeNode;
                    }
                    if (treeNode.left != null) {
                        stack.push(treeNode.left);
                        lastNode = treeNode;
                    }
                }
            }

        }
        return result;

    }


    //递归版本
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.right == null && root.left == null) {
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        list.remove(list.size() - 1);

        return result;
    }
```