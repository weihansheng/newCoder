import java.util.Arrays;

public class Solution50 {
    /**
     * 动态规划：
      用矩阵m记录第i为之前所有数字的乘积
      用矩阵n记录第i为之后所有数字的乘积
      B[i]=m[i]*n[i]; 时间复杂度O(n)
     */
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
//        System.out.println(Arrays.toString(m));
//        System.out.println(Arrays.toString(n));
        B[0]=n[0];
        B[A.length-1]=m[A.length-1];
        for (int i = 1; i <A.length-1 ; i++) {
            B[i]=m[i]*n[i];
        }
        return B;
    }

    public static void main(String[] args) {
        Solution50 solution50=new Solution50();
        int[] A={1};
        System.out.println(Arrays.toString(solution50.multiply(A)));
    }
}
