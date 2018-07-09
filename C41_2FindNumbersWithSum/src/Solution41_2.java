import java.util.*;
public class Solution41_2 {
    /**
     *
     定义两个指针 start end， 初始start指向数组的头，end指向数组尾
     如果array[start]+array[end]>sum end--
     如果array[start]+array[end]<sum start--
     如果array[start]+array[end]=sum 即为所求
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result= new ArrayList<>();
        int start =0;
        int end =array.length-1;
        while (start<=end){
            int curSum=array[start]+array[end];
            if (curSum<sum){
                start++;
            }else if(curSum>sum){
                end--;
            }else {
                result.add(array[start]);
                result.add(array[end]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array={1,2,4,7,11,15};
        Solution41_2 solution41_2=new Solution41_2();
        System.out.println(solution41_2.FindNumbersWithSum(array,15));
    }
}
