# 剑指Offer 54
## 链表中环的入口结点
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。


思路：

* 思路1:
左神讲的
     先说个定理：两个指针一个fast、一个slow同时从一个链表的头部出发
     fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
     此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
     这次两个指针一次走一步，相遇的地方就是入口节点。
     这个定理可以自己去网上看看证明。
    
* 思路2: 用set只能有一个元素的性质,第一个重复的节点就是入口节点
    
注意：

```java
//思路1
public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast==null||fast.next==null)
            return null;
        fast=pHead;
        while(fast!=null&&fast.next!=null){
            if (slow==fast){
                return slow;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return null;
    }
    //思路2
    public ListNode EntryNodeOfLoop2(ListNode pHead)
        {
            ListNode node=pHead;
            HashSet<ListNode> set=new HashSet<>();
            while(node!=null){
                if (!set.add(node)){
                    return node;
                }
                node=node.next;
            }
            return null;
    
        }
```
