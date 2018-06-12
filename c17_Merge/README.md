# 剑指Offer17
## 合并两个排序的链表
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

思路：每次比较两个链表的第一个结点，返回较小的那个 递归调用



```java
static ListNode Merge(ListNode list1,ListNode list2){
        if (list1==null) {
            return list2;
        }else if (list2==null){
            return list1;
        }
        ListNode mergeHead=null;
        if (list1.val<=list2.val){
            mergeHead=list1;
            mergeHead.next=Merge(list1.next,list2);
            return list1;
        }else {
            mergeHead=list2;
            mergeHead.next=Merge(list1,list2.next);
            return list2;
        }

    }
```
