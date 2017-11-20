# newCoder
### 复杂链表的复制
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

```java
/*递归思想：把大问题转化若干子问题
  此题转化为一个头结点和除去头结点剩余部分，剩余部分操作和原问题一致
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        RandomListNode newHead=new RandomListNode(pHead.label);
        newHead.label=pHead.label;
        newHead.random=pHead.random;
        newHead.next=Clone(pHead.next);
        return newHead;
    }
}
```