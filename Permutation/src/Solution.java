import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


/**
 * n个元素的全排列=1个作为前缀+剩余n-1个全排列
 * 出口：如果只剩一个元素，则表示全排列完成，输出数组
 * 不断将每个元素放左第一个元素,然后将它作为前缀,并将其余元素继续全排列
 * 需考虑有相同的如‘aa’ 的情况  使用HashSet存储
 */

public class Solution {
    HashSet<String> resultSet=new HashSet<>();
    ArrayList<String> result=new ArrayList<>();
    public void swapChar(char[] chars,int i,int j){
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }
    public void fullPerm(char[] chars,int start,int end){
        if(start==end){
            StringBuilder sb=new StringBuilder();
            for (char c : chars){
                sb.append(c);
            }
            resultSet.add(sb.toString());
            return;
        }else{
            for (int i=start;i<=end;i++){
                swapChar(chars,start,i);
                fullPerm(chars,start+1,end);
                //结束后需要换回来
                swapChar(chars,start,i);
            }
        }

    }
    public ArrayList<String> Permutation(String str){

        if (str.length()<1){
            return result;
        }
        char[] chars=str.toCharArray();
        fullPerm(chars,0,chars.length-1);
        result.addAll(resultSet);
        Collections.sort(result);
        return result;

    }
    public  static  void main(String arg[]){
        Solution solution=new Solution();
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList=solution.Permutation("1234");
        for (String str:arrayList){
            System.out.println(str);
        }

    }
}
