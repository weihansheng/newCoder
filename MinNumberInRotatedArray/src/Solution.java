public class Solution {
    /**
     * 思路：使用二分查找
     * 例如 3 4 5 1 2
     * 3 4 5为第一个递归数组 1 2为第二个递归数组
     * 使用指针index1指向第一个递归数组的头，index2指向第二个递归数组的尾 mid为当前index1和index2的中间元素
     * 如果array[mid]>=array[index] 则array[mid]属于第一个递归数组 最小元素应该在mid之后 令index1=mid
     * 如果array[mid]< array[index] 则array[mid]属于第二个递归数组 最小元素应该在mid之前或就是mid 令index2=mid
     * 对新的index1 和index2进行以上操作 知道index2-index1==1 array[index2]就是最小元素
     * 如果 数组本身就是排序数组如 1 2 3 4 5 就可以直接返回 array[index1] 所以mid初始化为index1
     * 如果遇到 1 0 1 1 1 或 1 1 1 0 1 就不能确定中间元素属于第几个递增数组 所以只能采用顺序查找
     *
     * @param array
     * @return
     */
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

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] array={3,4,5,1,2};
        System.out.println(solution.minNumberInRotateArray(array));
        int[] array2={1,0,1,1,1};
        System.out.println(solution.minNumberInRotateArray(array2));
    }
}
