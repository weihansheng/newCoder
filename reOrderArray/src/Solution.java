public class Solution {

    public void reOrderArray(int[] array) {

        int[] odd=new int[array.length];
        int[] even=new int[array.length];
        int oddSize=0;
        int evenSize=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]%2==0){
                //偶数
                even[evenSize++]=array[i];

            }else{
                //奇数
                odd[oddSize++]=array[i];
            }
        }
        for (int i = 0; i < oddSize; i++) {
            array[i]=odd[i];
        }
        for (int i = 0; i < evenSize; i++) {
            array[oddSize+i]=even[i];
        }
    }

    public   static  void main(String [] args){
        int[] array={1,2,3,4,5,6,7};
        Solution solution=new Solution();
        solution.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
