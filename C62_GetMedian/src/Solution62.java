import java.util.*;
public class Solution62 {
    // 大顶堆所有元素均小于等于小顶堆的所有元素.
    //小顶堆
    PriorityQueue<Integer> min_heap=new PriorityQueue<>();
    //大顶堆
    PriorityQueue<Integer> max_heap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int size=0;
    public void Insert(Integer num) {
        size=min_heap.size()+max_heap.size();
        //当数据总数为偶数时，新加入的元素，应当进入小根堆
        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
        //新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
        if (size%2==0){
            max_heap.offer(num);
            int filteredMaxNum = max_heap.poll();
            min_heap.offer(filteredMaxNum);
        }
        else{
        //当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            min_heap.offer(num);
            int filteredMinNum = min_heap.poll();
            max_heap.offer(filteredMinNum);
        }
    }

    public Double GetMedian() {
        size=min_heap.size()+max_heap.size();
        if (size%2==0){
            return (min_heap.peek()+max_heap.peek())/2.0;
        }
        else{//总数为奇数时 中位数为min_heap的根
            return min_heap.peek()/1.0;
        }

    }
    public static void main(String[] args) {
        Solution62 solution62=new Solution62();
        int[] arr={5,2,3,4,1,6,7,0,8};
        for (int a:arr) {
            solution62.Insert(a);
            System.out.println(solution62.GetMedian());
        }
    }
}
