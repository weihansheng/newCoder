
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

/*
* 解题思路： 
* 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
* 排序规则如下：
* 若ab > ba 则 a > b，
* 若ab < ba 则 a < b，
* 若ab = ba 则 a = b；
* 解释说明：
* 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较*/
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length==1)
            return String.valueOf(numbers[0]);
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            arrayList.add(numbers[i]);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        String result="";
        for (int i:arrayList){
            result=result+i;
        }
        return result;

    }
    public static  void main(String args[]){
        int num[]={3,32,321};
        Solution solution=new Solution();
        System.out.println(solution.PrintMinNumber(num));
    }
}
