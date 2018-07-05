public class Solution29 {
    /**
     *
     遍历数组，分别记录两个值，一个是数组中的一个数字，一个是次数
     当遍历数字时，如果下一个数字与之前保存的数字相同，则次数加1，否则次数减1，当次数为0时，需要重新保存一个数字
     因为我们要找的数字出现的次数比其他数字出现的次数之和还要多，那么要找的数字肯定是最后一个把次数设为1时对应的数字，
     如果这个数字不是，则没有. 因为 像 [1 2 3] 3是最后一个把次数设为1的，所以还要在遍历一次数组，看3的出现是不是超过了一半
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int times=0;
        int result=array[0];
        for (int v:array) {
            if (times==0){
                result=v;
                times=1;
            }else if (result==v){
                times++;
            }else{
                times--;
            }
        }
        //因为 像 [1 2 3] 3是最后一个把次数设为1的，所以还要在遍历一次数组，看3的出现是不是超过了一半
        times=0;
        for (int v:array) {
            if (v==result)
                times++;
        }
        if (times>array.length/2)
            return result;
        return 0;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,2,4,2,5,2,3};
        Solution29 solution29=new Solution29();
        System.out.println(solution29.MoreThanHalfNum_Solution(array));
    }
}
