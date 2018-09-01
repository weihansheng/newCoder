# 剑指Offer62
## 数据流中的中位数
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

思路：

用大顶堆和小顶堆存储
大顶堆所有元素均小于等于小顶堆的所有元素.

* 当数据总数为偶数时，新加入的元素，应当进入小根堆。
   
  （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
   新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
        
* 当数据总数为奇数时，新加入的元素，应当进入大根堆
  
  （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
  新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
  
* 总数为奇数时 中位数为min_heap的根
* 总数为偶数时 中位数为min_heap的根和max_heap跟的平均数


注意：

```java
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


```
