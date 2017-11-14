public class Solution {
    boolean judge(int[] sequence,int left,int right){
        if(left >= right) {
            return true;
        }
        //先找到中间节点 即第一个大于根节点的点
        int mid=left;
        while(mid<right&&sequence[mid]<sequence[right])
        {
            mid++;
        }
        //由于mid之前的都是小于root的 所以只需要遍历右半部分就行
        for (int i = mid; i <right ; i++) {
            if (sequence[i]<sequence[right]) {
                return false;
            }
        }

        return judge(sequence,left,mid-1)||judge(sequence,mid,right-1);

    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        int size=sequence.length;
        if (size==0)
            return false;

        return judge(sequence,0,size-1);
    }
    public static void main (String[] args){

        int[] sequence={4,8,6,12,16,14,10};
        Solution solution=new Solution();
        System.out.println(solution.VerifySquenceOfBST(sequence));
    }
}
