# 剑指Offer46
## 求1+2+3+...+n
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

思路：

    方法一：利用利用短路 && 来实现 if的功能  &&前面为假，后面不计算
    方法二：利用Math实现n(n+1)


```java
    public int Sum_Solution(int n) {
        int sum = n;
        //逻辑与，逻辑与有个短路特点，前面为假，后面不计算 ans并没有什么含义
        boolean ans=(n > 0) && ((sum += Sum_Solution(n-1))>0);
        return sum;
    }

```
