# newCoder
### 二进制中1的个数
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

思路：把一个整数减去1之后再和原来的整数做与运算，得到的整数相当于是把整数的二进制表示中的最右边的一个1变为0

相关题目：
* 用一条语句判断一个整数是不是2的整数次方
    * 2的整数次方的整数的二进制表示中只有一个1 把这个整数减去1再和自己做与运算，这个整数的唯一一个1就会变成0
* 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
    * 求m和n的异或
    * 统计异或结果中1的个数


```java
//把一个整数减去1之后再和原来的整数做与运算，得到的整数相当于是把整数的二进制表示中的最右边的一个1变为0
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0)
        {
            count++;
            n=n&(n-1);
        }
        return count;
    }

```