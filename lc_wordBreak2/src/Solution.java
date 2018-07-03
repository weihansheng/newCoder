import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     *
     思路：(动态规划问题)

     将问题划分为子问题，求s可以划分的句子，可以分为求s[0,i]和s[i+1,n-1]可以划分的句子集合连接 0<i<n；
     每个大问题是基于两个子问题，先求最子问题，自底向上求解
     求解公式:
     f(i)表示s[0,i]可以划分的句子的集合
     f(i)=f(j)+f(j+1，i) 0=<j<i
     初始化f(0)为空是因为当整个单词可分时也满足

     注意：s.substring(j,i)为s[j,i-1]
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> f=new ArrayList<>();
        int length=s.length();
        for (int i = 0; i <= length; i++) {
            ArrayList<String> value=new ArrayList<>();
            f.add(value);
            int start=0;
            for (int j = 0; j <=i ; j++) {
                String subS=s.substring(start,j);
                if (dict.contains(subS)){
                    f.get(i).add(subS);
                    start=j;
                }
            }
            if (start!=i){
                f.get(i).clear();
            }
        }

        return f.get(0);

    }

    public static void main(String[] args) {
        String s="catsanddog";
        Set<String> dict=new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        Solution solution=new Solution();
        solution.wordBreak(s,dict);
    }
}
