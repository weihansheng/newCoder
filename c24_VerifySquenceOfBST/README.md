# 剑指Offer24
## 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

思路：
* 二叉搜索树的根结点大于左节点得值，小于右节点的值
* 最后一个数字为根结点，左子树都比根结点小，有子树都比根结点大
* 在二叉搜索树中查找第一个大于根结点的位置mid，mid之前为左子树，mid只有为右子树
* 在右子树中如果有比根节点小的元素则不符合二叉搜索树的后续遍历

注意：

```java
 //二叉搜索树的根结点大于左节点得值，小于右节点的值
    //最后一个数字为根结点，左子树都比根结点小，有子树都比根结点大
    static public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) {
            return false;
        }
        return Judge(sequence,0,sequence.length-1);

    }

    static private boolean Judge(int[] sequence,int left,int right) {
        if (left>=right) {
            return true;
        }
        int root= sequence[right];
        int mid=left;
        //在二叉搜索树中查找第一个大于根结点的位置mid，mid之前为左子树，mid只有为右子树
        while (sequence[mid]<root){
            mid++;
        }
        //右子树中如果有比根节点小的元素则不符合二叉搜索树的后续遍历
        for (int i = mid+1; i <right ; i++) {
            if (sequence[i]<root){
                return false;
            }
        }
        return Judge(sequence,left,mid-1)&&Judge(sequence,mid,right-1);
    }

 //测试数据 
//        int[] array={5,7,6,9,11,10,8};
//        int[] array={7,4,5,6};
//        int[] array={7,4};
//        int[] array={4,7};
//        int[] array={5,4,3,2,1};
//        int[] array={1,2,3,4,5};

```
