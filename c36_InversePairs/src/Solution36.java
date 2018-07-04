import java.util.*;
public class Solution36 {
    /**
     copy位辅助数组,用于存放排序好的数组
     本质就是归并排序,归并的时候记录count值
     合并两个数组时,两个数组的指针从后往前遍历,每次把最大的拷贝到copy中,拷贝的同时计算逆序两个数组之间的逆序数
     如合并a1=[5,7] 和 a2=[4,6]:  只有当a1中的最后一位大于a2中最后一位时才更新count.
     初始count=0,比较a1和a2的最后一位 7>6, 先拷贝7,此时比7小的数位a2中元素个数2,count=count+2;
     此时a1=[5], a2=[4,6], 比较a1和a2的最后一位 6>5, 拷贝6 count不变, 循环以上步骤,直到两个数组遍历完
     **/
//    public int InversePairs(int [] array) {
//        if (array.length==0||array.length==1){
//            return 0;
//        }
//        int[] copy=new int[array.length];
//        for(int i=0;i<array.length;i++)
//        {
//            copy[i] = array[i];
//        }
//        return InversePairsCore(array,copy,0,array.length-1);
//    }
//

    int InversePairsCore(int[] array,int[] copy,int start,int end){
        if (start==end) {
            copy[start]=array[start];
            return 0;
        }
        int length=(end-start)/2;
        int left=InversePairsCore(array,copy,start,start+length);
        int right=InversePairsCore(array,copy,start+length+1,end);
        int count=0;
        //记录两个数组的指针
        int i1=start+length;
        int i2=end;
        //记录copy的指针 从后往前
        int index=end;
        while(i1>=start&&i2>=start+length+1){
            if (array[i1]>array[i2]){
                count=count+(i2-start-length);
                copy[index--]=array[i1--];
            }else{
                copy[index--]=array[i2--];
            }
        }
        while (i1>=start){
            copy[index--]=array[i1--];
        }
        while (i2>=start+length+1){
            copy[index--]=array[i2--];
        }
        array=copy;
        System.out.println(count);
        return count+left+right;

    }
    int count=0;
    public int InversePairs(int [] array) {
        if (array.length==0||array.length==1){
            return 0;
        }
        mergeSort(array,0,array.length-1);
        return count;
    }
    void mergeSort(int[] array,int start,int end){
        int mid= (end+start)/2;
        if (start<end){
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }
    void merge(int[] array,int start,int mid,int end){
        int[] copy=new int[end-start+1];
        int i1=mid;
        int i2=end;
        int index=copy.length-1;
        while(i1>=start&&i2>=mid+1){
            if (array[i1]>array[i2]){
                count=count+(i2-mid);
                count=count%1000000007;
                copy[index--]=array[i1--];
            }else{
                copy[index--]=array[i2--];
            }
        }
        while (i1>=start){
            copy[index--]=array[i1--];
        }
        while (i2>=mid+1){
            copy[index--]=array[i2--];
        }
        for (int data:copy) {
            array[start++]=data;
        }

    }

    public static void main(String[] args) {
//        int[] array={7,5,6,4};
        int[] array={1,2,3,4,5,6,7,0};
        Solution36 solution36=new Solution36();
        System.out.println(solution36.InversePairs(array));
    }
}
