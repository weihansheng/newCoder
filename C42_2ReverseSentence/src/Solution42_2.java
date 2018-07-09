public class Solution42_2 {
    /**
     *
     第一步 先翻转整个句子 这一步会把每个单词也翻转
     第二步 翻转每个单词
     */
    public String ReverseSentence(String str) {
        if (str==null){
            return "";
        }
        int length=str.length()-1;
        str=Reverse(str,0,length);
        System.out.println(str);
        char[] s=str.toCharArray();
        int start=0;
        int end=0;
        for (int i = 0; i <length ; i++) {
            if (str.charAt(i)==' '){
                end= i-1;
                str=Reverse(str,start,end);
                System.out.println(str);
                start=i+1;
            }
        }
        //旋转最后一个单词
        str=Reverse(str,start,length);
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
        String str=null;
        Solution42_2 solution42_2=new Solution42_2();
        System.out.println(solution42_2.ReverseSentence(str));
    }
}
