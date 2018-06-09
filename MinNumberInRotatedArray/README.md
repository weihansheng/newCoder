# newCoder
### 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

思路：使用二分查找

     * 例如 3 4 5 1 2
     * 3 4 5为第一个递归数组 1 2为第二个递归数组
     * 使用指针index1指向第一个递归数组的头，index2指向第二个递归数组的尾 mid为当前index1和index2的中间元素
     * 如果array[mid]>=array[index] 则array[mid]属于第一个递归数组 最小元素应该在mid之后 令index1=mid
     * 如果array[mid]< array[index] 则array[mid]属于第二个递归数组 最小元素应该在mid之前或就是mid 令index2=mid
     * 对新的index1 和index2进行以上操作 知道index2-index1==1 array[index2]就是最小元素
     * 如果 数组本身就是排序数组如 1 2 3 4 5 就可以直接返回 array[index1] 所以mid初始化为index1
     * 如果遇到 1 0 1 1 1 或 1 1 1 0 1 就不能确定中间元素属于第几个递增数组 所以只能采用顺序查找

```java
public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        int index1=0;
        int index2=array.length-1;
        int mid=index1;
        while(array[index1]>=array[index2]){
            if (index2-index1==1){
                return array[index2];
            }
            mid=(index1+index2)/2;
            //如果遇到 1 0 1 1 1 或 1 1 1 0 1 就不能确定中间元素属于第几个递增数组 所以只能采用顺序查找
            if (array[index1]==array[mid]&&array[index2]==array[mid])
            {
                int min=array[index1];
                for (int i=index1;i<index2;i++)
                {
                    if (array[i]<=min)
                        min=array[i];
                }
                return min;
            }
            if (array[mid]>=array[index1]){
                index1=mid;
            }else{
                index2=mid;
            }
        }
        return array[mid];
    }

```