# 剑指Offer42——2
## 左旋字符串
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

思路：

     第一步 翻转整个字符串，此过程会把所有的子字符串序列翻转
     第二步 翻转第一个子串 使第一个子串的顺序正常
     第三步 翻转第二个子串 使第二个子串的顺序正常


注意：

```java
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

```
