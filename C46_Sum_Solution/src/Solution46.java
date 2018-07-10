public class Solution46 {
    /**
     方法一：利用利用短路 && 来实现 if的功能  &&前面为假，后面不计算
     方法二：利用Math实现n(n+1)
     */
    public int Sum_Solution(int n) {
        int sum = n;
        //逻辑与，逻辑与有个短路特点，前面为假，后面不计算 ans并没有什么含义
        boolean ans=(n > 0) && ((sum += Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        Solution46 solution46=new Solution46();
        System.out.println(solution46.Sum_Solution(4));
    }
}
