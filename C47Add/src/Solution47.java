public class Solution47 {
    /**
     *
     第一步:各位相加，但不计进位，
     第二步:记下进位
     第三步:从前两步得到的两个数递归调用Add 直到进位==0
     如5+17 101+10001
     1. 各位相加不计进位 得到10100 其实就是：^ 异或运算
     2. 进位为10  计算过程101&10001 得到1 左移一位 得到10  先与运算再左移
     重复上述步骤 Add(10001,10)
     */
    public int Add(int num1,int num2) {
        while(num2!=0){
            int jinwei=(num1&num2)<<1;
            int add=num1^num2;
            num1=add;
            num2=jinwei;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution47 solution47= new Solution47();
        System.out.println(solution47.Add(15,7));
    }

}
