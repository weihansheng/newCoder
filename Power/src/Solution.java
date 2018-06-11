import javax.sound.midi.Soundbank;

public class Solution {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 要考虑指数的正负、底数是否为零等情况 当底数为0且指数小于0是为无效输入 使用全局变量g_InvalidInput 标识是否出错
     * 由于计算机表示小数时有误差 不能简单的用==判断两个小数是否相等 如果两个小数的差的绝对值小于0.0000001时 就认为它们相等
     * 快速幂用递归实现：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
     时间复杂度O（logn）
     *
     */
    boolean g_InvalidInput=false;
    double Power(double base, int exponent) {
        if (equalDouble(base,0)&&exponent<0){
            g_InvalidInput=true;
            return 0;
        }
        int absExponent=Math.abs(exponent);
        double result=PowerWithUnsignedExponent(base,absExponent);
        return exponent>0?result:(1/result) ;

    }

    boolean equalDouble(double num1,double num2){
        if (num1-num2<0.0000001&&num1-num2>-0.0000001)
        {
            return true;
        }else {
            return false;
        }
    }
    double PowerWithUnsignedExponent(double base,int exponent){
        if (exponent==0)
            return 1;
        if (exponent==1)
            return base;
        double result=PowerWithUnsignedExponent(base,exponent>>1);
        result=result*result;
        //(exponent&1)==1 相当于 (exponent%2)==1 位运算比乘除及求余运算要高效得多
        if ((exponent&1)==1){
            result=result*base;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.Power(2.0,-3));
        System.out.println(3>>1);
    }
}
