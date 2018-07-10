public class Solution49 {

    /**
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * @return true if the input is valid, and there are some duplications in the array number
                        ,otherwise false
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||numbers.length<=0) {
            duplication[0] = -1;
            return false;
        }
        int count[]=new int[length];
        for (int num:numbers) {
            count[num]++;
            if (count[num]>1)
            {
                duplication[0]=num;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution49 solution49=new Solution49();
        int array[]={1,2,5,4,5,1};
        System.out.println(solution49.duplicate(array,6,array));
    }
}
