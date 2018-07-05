public class Solution38 {
    /**
     *统计一个数字在排序数组中出现的次数。
     *分析：有序数组可考虑二分法
     *思路：
     * 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
     * 这两个数应该插入的位置，然后相减即可
     */
    public int GetNumberOfK(int [] array , int k) {
        return biSearch(array,k+0.5)-biSearch(array,k-0.5);
    }
    private int biSearch(int[] array, double v) {
        int start=0;
        int end=array.length-1;
        int mid=(start+end)/2;
        while (start<=end){
            if (array[mid]<v){
                start=mid+1;

            }else{
                end=mid-1;
            }
            mid=(start+end)/2;

        }
        //返回可插入的位置
        return start;
    }

    public static void main(String[] args) {
        int[] array={1,2,2,2,3,3,4,5,6,7};
        Solution38 solution38=new Solution38();
        System.out.println(solution38.biSearch(array,2.5));
        System.out.println(solution38.biSearch(array,3.5));
    }
}
