# 剑指Offer 55
## 删除该链表中重复的结点
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5


思路：

非递归的代码：
 * 1.首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
 * 2.设置 pre ，cur 指针， pre指针指向当前确定不重复的那个节点，而cur指针相当于工作指针，一直往后面搜索。
注意：

```java
//非递归  
public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)
            return pHead;
        ListNode newHead=new ListNode(-1);
        newHead.next=pHead;
        ListNode pre=newHead;
        ListNode cur=pHead;
        while (cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                int num=cur.val;
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                while(cur!=null&&cur.val==num){
                    cur=cur.next;
                }
                //指针赋值，就相当于删除
                pre.next=cur;
            }else {
                //如果当前节点和下一个节点值不等，则向后移动一位
                pre=cur;
                cur=cur.next;
            }
        }
        return newHead.next;

    }
    
    //递归  
    ListNode deleteDuplication(ListNode pHead)
        {
            if (pHead==null||pHead.next==null)
                return pHead;
            ListNode current;
            if (pHead.val==pHead.next.val) {
                //找到第一个不同的节点
                current = pHead.next.next;
                //如果当前节点的值与之前删除的相同
                while (current!=null&&current.val==pHead.val)
                    current=current.next;
                return deleteDuplication(current);
            }else {
                current=pHead.next;
                pHead.next=deleteDuplication(current);
                return pHead;
            }
        }
```
