import java.util.*;

public class Solution44 {
    /**
     *
     第一步：将数组排序
     第二步：遍历数组，统计0的个数，同时记录非零元素
     第三遍：统计非零元素之间的空缺的总数，如果总数<=0的个数 返回true 否则返回false
     注意：如果有两个元素相同 即有对子 则可返还false
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length<5)
            return false;
        Arrays.sort(numbers);
        int numberof0=0;
        ArrayList<Integer> listNot0=new ArrayList<>();
        for (int n:numbers) {
            if (n==0)
            {
                numberof0++;
            }else {
                if (listNot0.contains(n)){
                    return false;
                }else {
                    listNot0.add(n);
                }
            }
        }
        int gap=0;
        for (int i = 0; i <listNot0.size()-1 ; i++) {
            gap+=listNot0.get(i+1)-listNot0.get(i)-1;
        }
        if (numberof0-gap>=0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution44 solution43= new Solution44();
        int num[]={1,0,3,0,6};
        System.out.println(solution43.isContinuous(num));
    }
}
