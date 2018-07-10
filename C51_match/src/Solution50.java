import java.util.*;

public class Solution50 {
    //"",".*" 为true "","c*"
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < str.length && j < pattern.length) {
            if (str[i] == pattern[j] || pattern[j] == '.') {
                i++;
                j++;
            } else if (pattern[j] == '*') {
                if (j > 0 & str[i] == pattern[j - 1]) {
                    i++;
                } else {
                    j++;
                }
            }
//            else if(j>0&i>0&pattern[j-1]=='*'&pattern[j]==str[i-1]){
//                j++;
//            }
            else {
                j++;
            }

        }
        if (pattern.length - j == 2 & pattern[pattern.length - 1] == '*'){
            return true;
        }
        if (i==str.length&&j==pattern.length){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution50 solution50=new Solution50();
//        String str="";
        String str="aaa";
//        String pattern="ab*ac*a";
//        String pattern="ab*a";
        String pattern="a.a";
//        String pattern="aa.a";
//        String pattern="a*";
        System.out.println(solution50.match(str.toCharArray(),pattern.toCharArray()));
    }
}
