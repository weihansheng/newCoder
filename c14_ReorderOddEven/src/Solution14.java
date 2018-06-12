import java.util.Arrays;

public class Solution14 {
    /**
     * 此题跟牛客网不一样 不能保证奇数和奇数，偶数和偶数之间的相对位置不变
     * 调整该数组中数字的顺序，使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 思路：用两个指针i，j；i从头开始扫找偶数，j从尾开始扫找奇数，互换i，j的位置  循环跳出条件：i>=j
     */
    static void ReorderOddEven(int[] array){
        int i=0;
        int j=array.length-1;
        int tmp;
        while (i<j){
            //找偶数
            while (!isEven(array[i])){
                i++;
            }
            //找奇数
            while (isEven(array[j])){
                j--;
            }
            if (i<j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }
    //此函数可以换成其他的分组标准 如是否能被三整除...
    //用位操作判断是否是偶数
    static boolean isEven(int n){
        return (n&1)==0;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        ReorderOddEven(array);
        System.out.println(Arrays.toString(array));
    }
}
