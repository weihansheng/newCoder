# 剑指Offer63
## 滑动窗口的最大值
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

思路：

* 用一个双向队列deque来存储，队列从大到小排序，注意：这存的是数组元素的索引,是为了便于判断队列元素是否超过窗口大小
* 如果新来的值比队列尾部的数小，那就追加到后面，因为它可能在前面的最大值划出窗口后成为最大值
* 如果新来的值比尾部的大，那就删掉尾部（因为有更大的在后面，所以它不会成为最大值，划出也是它先划出，不影响最大值），再追加到后面，循环下去直到小于
* 如果追加的值比的索引跟队列头部的值的索引超过窗口大小，那就删掉头部的值
* 其实这样每次队列的头都是最大的那个


注意：

```java
public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<>();
        //用双端队列存数组元素的下表，而不是数组元素，是为了便于判断队列元素是否超过窗口大小
        Deque<Integer> deque=new ArrayDeque<>();
        if (num.length<=0||size<=0){
            return result;
        }
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty()&&(i - deque.peekFirst()) == size){
                // 如果队列头部的元素已经超出滑动窗口的范围，就将头部元素退出
                deque.pollFirst();
            }
            //如果新来的值比队列尾部的数小，那就追加到后面，因为它可能在前面的最大值划出窗口后成为最大值
            while(!deque.isEmpty()&& num[i]>=num[deque.peekLast()]){
                // 如果新来的元素比队列最后一个元素大，则将最后一个元素退出
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= (size - 1)) {
                // 如果遍历的元素已经达到一个滑动窗口的大小，就开始提取窗口的最大值了
                result.add(num[deque.peekFirst()]);
            }

        }
        return result;

    }

```
