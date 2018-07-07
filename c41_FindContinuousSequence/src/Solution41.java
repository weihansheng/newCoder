import java.util.*;

public class Solution41 {
    /**
     用 start和end表示序列的开始和结束
     如果从start到end的和大于sum,我们从序列中去掉较小的值,即start++
     如果从start到end的和小于sum,我们从序列包含更多的数字,即end++
     直到small增加到(1+sum)/2

     注意:求start到end的和可以根据等差数列前n项和公式S=n*a1+(n*(n-1))/2
     */

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        int start=1;
        int end=2;
        int S=0;
        while (start<=(sum+1)/2){
            int n=end-start+1;
            int a1=start;
            S=n*a1+(n*(n-1))/2;
            if (S<sum){
                end++;
            }else if(S>sum){
                start++;
            }else {
                //System.out.println("start:"+start+" end:"+end);
                ArrayList<Integer> result=new ArrayList<>();
                for (int i = start; i <=end ; i++) {
                    result.add(i);
                }
                results.add(result);
                start++;
            }
        }
        return results;

    }

    public static void main(String[] args) {
        Solution41 solution41=new Solution41();
        ArrayList<ArrayList<Integer>> results=solution41.FindContinuousSequence(100);
//        System.out.println(results.size());
        for (ArrayList<Integer> result:results) {
            System.out.println(result.toString());
        }
    }
}
