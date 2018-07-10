# 剑指Offer50
## 构建乘积数组
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

思路：

      动态规划：
      用矩阵m记录第i为之前所有数字的乘积
      用矩阵n记录第i为之后所有数字的乘积
      B[i]=m[i]*n[i]; 时间复杂度O(n)
      
      暴利方法：  
      B[0] = A[1] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[0]）
      B[1 ]= A[0] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[1]）
      B[2] = A[0] * A[1] * A[3] * A[4] *....*A[n-1] ;（没有A[2]）
      ....
      即B[i]项等于A数组所有数的乘积，但是去除A[i]项。由于是乘法，所以直接令A[i]项等于1即可。


```java
public int[] multiply(int[] A) {
        if (A==null||A.length<=0){
            return null;
        }
        if (A.length==1){
            return A;
        }
        //i之前的乘积
        int[] m=new int[A.length];
        //i之后的乘积
        int[] n=new int[A.length];
        int[] B=new int[A.length];
        m[0]=1;
        m[1]=A[0];
        for (int i = 2; i <A.length ; i++) {
            m[i]=m[i-1]*A[i-1];
        }
        n[A.length-1]=1;
        n[A.length-2]=A[A.length-1];
        for (int i = A.length-3; i >=0 ; i--) {
            n[i]=n[i+1]*A[i+1];
        }
        B[0]=n[0];
        B[A.length-1]=m[A.length-1];
        for (int i = 1; i <A.length-1 ; i++) {
            B[i]=m[i]*n[i];
        }
        return B;
    }

```
