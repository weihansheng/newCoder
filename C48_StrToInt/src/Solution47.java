public class Solution47 {
    /**
     *
     需要考虑+ -符号 和其他非数字的字符
     使用变量isValid标记输入是否有非法字符  isMinus标识数字的正负
     */
    public int StrToInt(String str) {
        if (str==null||str.length()<=0) {
            return 0;
        }
        boolean isValid=true;
        boolean isMinus=false;
        int start=0;
        if (str.charAt(0)=='-'){
            isMinus=true;
            start++;
        }else if (str.charAt(0)=='+'){
            start++;
        }else {
            if (str.charAt(0)<'0'&&str.charAt(0)>'9'){
                isValid=false;
            }
        }
        int result=0;
        char c=' ';
        for (int i = start; i <str.length() ; i++) {
            c=str.charAt(i);
            if (c>='0'&&c<='9') {
                result = result * 10 + c - '0';
            }else {
                isValid=false;
            }
        }
        if (!isValid){
            return 0;
        }

        return isMinus?-result:result;
    }

    public static void main(String[] args) {
        Solution47 solution47=new Solution47();
        System.out.println(solution47.StrToInt("0"));
    }
}
