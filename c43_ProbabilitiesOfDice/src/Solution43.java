import java.util.Arrays;
import java.util.Scanner;

public class Solution43 {
    /**
     * 网易笔试https://www.nowcoder.com/questionTerminal/4ac62a94e4ba49df86a66eb7c44fa96a
     n个骰子的和有 6*n-n+1  最大6n 最小n
     用f[n][m]表示投第n个筛子时点数之和为m的个数
     投第n个筛子的点数之和只与投第n-1个筛子有关
     f(n,m)=f(n-1,m-1)+f(n-1,m-2)+f(n-1,m-2)+f(n-1,m-3)+f(n-1,m-4)+f(n-1,m-5)+f(n-1,m-6)
     表示本轮点数之和为n的次数等于上一轮点数和为n-1,n-2,n-3,n-4,n-5,n-6出现的次数之和
     例如:
     f(2,6)=f(1,5)+f(1,4)+f(1,3)+f(1,2)+f(1,1)+f(1,0)=1+1+1+1+1=5
     f(3,6)=f(2,5)+f(2,4)+f(2,3)+f(2,2)+f(2,1)+f(2,0)
     如果有空间限制 其实只需要用两个数组 一个表示上次的和的次数,一个用来表示本次和出现的次数,用flag区分本次和上次

     注意: 由于6的n次方可能会超过int的表示范围,所以 f和 count都要用long
     */

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
//        System.out.println(Arrays.toString(f[1]));
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
//            System.out.println(Arrays.toString(f[i]));
        }
        return f[n];
    }

    /**
     * 辗转相除法：
     目的：求两个整数的最大公约数
     最大公约数：能同时被两个整数整除的最大公约数
     原理：
     最大公约数 = 小数 与 （大数%小数） 的最大公约数
     利用这条原理，反复执行，直到   大数%小数 = 0，此时较小的数就是原来两数的最大公约数
     * @param x
     * @param y
     * @return
     */
    public static long gcd(long x, long y){ // 这个是运用辗转相除法求 两个数的 最大公约数 看不懂可以百度 // 下
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }
    public static void main(String[] args) {
        Solution43 solution43=new Solution43();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        long[] f=solution43.probabilities(n);
        long count=0;
        for (int i =x ; i <=6*n ; i++) {
            count+=f[i];

        }
        long max=(long)Math.pow(gMax,n); //最多gMax的n次方种情况
        long g=gcd(count,max);
        if (count==0)
            System.out.println(0);
        else if (count==max)
            System.out.println(1);
        else
            System.out.println(count/g+"/"+max/g);
    }
}
