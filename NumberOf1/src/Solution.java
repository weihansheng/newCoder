import sun.jvm.hotspot.utilities.Bits;

public class Solution {
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
    public static void main(String[] args) {
        Solution solution=new Solution();
        int num=1;
        System.out.println(solution.NumberOf1(num));
    }
}
