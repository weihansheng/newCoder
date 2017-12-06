
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //维护最小堆性质 是i结点和i的孩子节点满足最小堆性质  时间复杂度为树的高度O(lg(n))
    public  void minHeapfy(int a[],int heapSize,int i){
        int lChild=2*i+1;
        int rChild=2*i+2;
        int large=i;
        if(lChild<heapSize&&a[lChild]<a[i])
        {
            large=lChild;
        }
        if (rChild<heapSize&&a[rChild]<a[large]){
            large=rChild;
        }
        if(i!=large){
            int tmp=a[i];
            a[i]=a[large];
            a[large]=tmp;
            minHeapfy(a,heapSize,large);
        }

    }
    //构建最小堆，由于(n/2+1)--n中的元素都是叶子节点，所以只需要对0-n/2最小堆处理即可
    public void buildMinHeap(int a[]){
        if (a == null || a.length <= 1) {
            return;
        }
        for(int i=a.length/2;i>=0;i--){
            minHeapfy(a,a.length,i);
        }
    }

    //基于堆排序算法，构建最小堆。时间复杂度为O(n*lgk)
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if (input.length<=0||k>input.length){
            return result;
        }
        buildMinHeap(input);
        for (int i=input.length-1;i>=input.length-k;i--){
            int tmp=input[0];
            input[0]=input[i];
            input[i]=tmp;
            minHeapfy(input,i,0);
            result.add(tmp);
        }
        return result;

    }
    public void minMHeapSort(int a[])
    {
        buildMinHeap(a);
        //由于最大值总在根节点a[0]，每次找到一个最大值，heapSize-1
        // 再对0-heapSize的元素进行最大堆处理
        // 时间复杂度O(n*lg(n))
        for (int i=a.length-1;i>=1;i--){
            int tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            minHeapfy(a,i,0);
        }
    }
    public static  void main(String arg[]){
//        int a[]={4,1,3,2,16,9,10,14,8,7};
        int a[]={4,5,1,6,2,7,3,8};
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> result=new ArrayList<>();
        Solution solution=new Solution();
        solution.buildMinHeap(a);
        System.out.println(Arrays.toString(a));
        result=solution.GetLeastNumbers_Solution(a,10);
        System.out.println(result);
    }
}
