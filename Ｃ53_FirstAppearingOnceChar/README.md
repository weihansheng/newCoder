# 剑指Offer 53
## 字符流中第一个只出现一次的字符
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。


如果当前字符流没有存在出现一次的字符，返回#字符

思路：
    
    使用int hash[256]数组中 记录每个字符出现的次数
    用StringBuffer记录字符出现的顺序
    


```java
int[] hash=new int[256];
    StringBuffer string=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        string.append(ch);
        hash[ch]++;

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for (char c: string.toString().toCharArray()) {
            if (hash[c]==1){
                return c;
            }
        }
        return '#';
    }
```
