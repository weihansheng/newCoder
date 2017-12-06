
import java.util.Arrays;

public class Solution {
    //维护最大堆性质 是i结点和i的孩子节点满足最大堆性质  时间复杂度为树的高度O(lg(n))
    public  void maxHeapfy(int a[],int heapSize,int i){
        int lChild=2*i+1;
        int rChild=2*i+2;
        int large=i;
        if(lChild<heapSize&&a[lChild]>a[i])
        {
            large=lChild;
        }
        if (rChild<heapSize&&a[rChild]>a[large]){
            large=rChild;
        }
        if(i!=large){
            int tmp=a[i];
            a[i]=a[large];
            a[large]=tmp;
            maxHeapfy(a,heapSize,large);
        }

    }
    public void buildMaxHeap(int a[]){
        if (a == null || a.length <= 1) {
            return;
        }
        for(int i=a.length/2;i>=0;i--){
            maxHeapfy(a,a.length,i);
        }
    }
    public void maxHeapSort(int a[])
    {
        buildMaxHeap(a);
        //由于最大值总在根节点a[0]，每次找到一个最大值，heapSize-1
        // 再对0-heapSize的元素进行最大堆处理
        // 时间复杂度O(n*lg(n))
        for (int i=a.length-1;i>=1;i--){
            int tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            maxHeapfy(a,i,0);
        }
    }
    public static  void main(String arg[]){
        int a[]={4,1,3,2,16,9,10,14,8,7};
        System.out.println(Arrays.toString(a));
        Solution solution=new Solution();
        solution.maxHeapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
