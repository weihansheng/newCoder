public class Solution {
    /**
     *统计一个数字在排序数组中出现的次数。
     *分析：有序数组可考虑二分法
     *思路：
     * 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
     * 这两个数应该插入的位置，然后相减即可。
     */

    public int biSearch(int[] array,double num){
        int low=0;
        int hign=array.length-1;
        int mid=0;
        while (low<=hign){
            mid=(hign+low)/2;
            if (array[mid]<num){
                low=mid+1;
            }else if (array[mid]>num)
            {
                hign=mid-1;
            }else{
                return mid;
            }
        }
        //返回可插入的位置
        return low;
    }
    public int GetNumberOfK1(int [] array , int k) {
        int count=0;
        for (int data:array) {
            if (data<=k){
                if (k==data){
                    count++;
                }
            }else
            {
                break;
            }
        }

        return count;
    }
    public int GetNumberOfK(int [] array , int k) {
        return biSearch(array,k+0.5)-biSearch(array,k-0.5);
    }
    public static void main(String[] args){
        int[] array={1,2,3,3,3,3,4,5};
        Solution solution=new Solution();
        System.out.println(solution.GetNumberOfK(array,3));
        System.out.println(solution.biSearch(array,3.5));
        System.out.println(solution.biSearch(array,2.5));
    }
}
