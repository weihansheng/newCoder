import javax.sound.midi.Soundbank;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int[] a =new int[array.length+1];
        int maxNum=0;
        int maxInt=array[0];
        for (int i=0;i<array.length;i++)
        {
            a[array[i]]++;
            if (a[array[i]]>maxNum) {
                maxNum = a[array[i]];
                maxInt=array[i];
            }
        }
        if (maxNum<=array.length/2) {
            maxInt=0;
        }
        return maxInt;
    }
    public static void main(String[] arg){
        int[] a={1};
        Solution solution=new Solution();
        System.out.println(solution.MoreThanHalfNum_Solution(a));
    }
}
