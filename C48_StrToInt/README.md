# 剑指Offer48
## 把字符串转换成整数
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0

思路：

     需要考虑+ -符号 和其他非数字的字符
     使用变量isValid标记输入是否有非法字符  isMinus标识数字的正负


注意：输入为空 和非法字符

```java
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

```
