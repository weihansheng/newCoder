public class Solution42 {
    /**
     *
     第一步 翻转整个字符串，此过程会把所有的子字符串序列翻转
     第二步 翻转第一个子串 使第一个子串的顺序正常
     第三步 翻转第二个子串 使第二个子串的顺序正常
     */
    public String LeftRotateString(String str,int n) {
        if (str.length()==0)
            return "";
        if (str.length()==1)
            return str;
        int length=str.length()-1;
        str=Reverse(str,0,length);
        str=Reverse(str,length-n+1,length);
        str=Reverse(str,0,length-n);
        return str;
    }
    public String Reverse(String str,int start,int end){
        char[] s=str.toCharArray();
        char tmp=' ';
        while(start<=end){
            tmp=s[start];
            s[start]=s[end];
            s[end]=tmp;
            start++;
            end--;
        }
        return String.copyValueOf(s);
    }

    public static void main(String[] args) {
        Solution42 solution42=new Solution42();
        String str="abcXYZdef";
//        System.out.println(solution42.Reverse(str,0, str.length()-1));
        System.out.println(solution42.LeftRotateString(str,3));
    }
}
