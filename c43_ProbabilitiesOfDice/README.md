# 剑指Offer 43 
## n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s，
输入n，打印出s的所有可能的值出现的概率。

类似题目:

网易笔试https://www.nowcoder.com/questionTerminal/4ac62a94e4ba49df86a66eb7c44fa96a

思路：
    
         n个骰子的和有 6*n-n+1  最大6n 最小n
         用f[n][m]表示投第n个筛子时点数之和为m的个数
         投第n个筛子的点数之和只与投第n-1个筛子有关
         f(n,m)=f(n-1,m-1)+f(n-1,m-2)+f(n-1,m-2)+f(n-1,m-3)+f(n-1,m-4)+f(n-1,m-5)+f(n-1,m-6)
         表示本轮点数之和为n的次数等于上一轮点数和为n-1,n-2,n-3,n-4,n-5,n-6出现的次数之和
         例如:
         f(2,6)=f(1,5)+f(1,4)+f(1,3)+f(1,2)+f(1,1)+f(1,0)=1+1+1+1+1=5
         f(3,6)=f(2,5)+f(2,4)+f(2,3)+f(2,2)+f(2,1)+f(2,0)
         如果有空间限制 其实只需要用两个数组 一个表示上次的和的次数,一个用来表示本次和出现的次数,用flag区分本次和上次
    
         
    
注意：

由于6的n次方可能会超过int的表示范围,所以 f和 count都要用long

```java
 /**
     *  n 筛子的个数
     *  gMax 每个筛子的最大点数
     *  返回值为 所有点数和出现的次数
     */
    static int gMax=6;
    long[] probabilities(int n){
        int maxSum=gMax*n;
        long[][] f=new long[n+1][maxSum+1];
        int flag=0;
        //初始化第1个筛子和的次数
        for (int i = 1; i <=gMax ; i++) {
            f[1][i]=1;
        }
        //求投第i个筛子和的次数
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=maxSum ; j++) {
                for (int k = 1; k <=gMax ; k++) {
                    if (j-k>0){
                        f[i][j]+=f[i-1][j-k];
                    }else {
                        //j-k<=0时后面的不用再加,都是0
                        break;
                    }
                }
            }
        }
        return f[n];
    }
```
