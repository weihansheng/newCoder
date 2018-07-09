# 剑指Offer42_2
## 翻转单词顺序列
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

思路：

     第一步 先翻转整个句子 这一步会把每个单词也翻转
     第二步 翻转每个单词



注意：

```java
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

```
