import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_wordBreak {
    /**
     *
     思路：(动态规划问题)

     将问题划分为子问题，判断s是否可以分词，可以分为判断s[0,i]和s[i+1,n-1]是否可以分词 0<i<n；
     每个大问题是基于两个子问题，先求最子问题，自底向上求解
     求解公式:
     f(i)表示s[0,i]是否可以分词
     f(i)=f(j)&&f(j+1，i) 0=<j<i
     初始化f(0)为true是因为当整个单词可分时也满足

     注意：s.substring(j,i)为s[j,i-1]
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int length=s.length();
        boolean[] f=new boolean[length+1];
        f[0]=true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <i ; j++) {
                String sb_s=s.substring(j,i);
                if (f[j]&&dict.contains(sb_s)){
                    f[i]=true;
                    //如果有一个可分的，就可以跳出第二个for循环
                    break;
                }
            }
        }
        return f[length];
    }

    public static void main(String[] args) {
        String s="leetcode";
        Set<String> dict=new HashSet<String>();
        dict.add("leetcode");
        dict.add("cod");
        Solution_wordBreak solution=new Solution_wordBreak();
        System.out.println(solution.wordBreak(s,dict));
        System.out.println("hello".substring(1,5));
    }
}
