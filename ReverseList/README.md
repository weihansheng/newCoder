# newCoder
### 反转链表
输入一个链表，反转链表后，输出链表的所有元素。

```java

public class Solution {
    //方法一： 从原链表的头部一个一个取节点并插入到新链表的头部
    public ListNode ReverseList1(ListNode head) {

        if (head==null)
        {
            return head;
        }
        ListNode newHead=new ListNode(head.val);
        newHead.next=null;
        ListNode tmp=null;
        head=head.next;
        while (head!=null){
            ListNode node=new ListNode(head.val);
            tmp=newHead;
            node.next=tmp;
            newHead=node;
            head=head.next;
        }
        return newHead;
    }
    /* 方法二：指针反转
       1. 1->2->3->null
       2. 1<-2  3->null
       3. 1<-2<-3->null
       # 文字描述过程:
       * 关键点: **由于反转后不能访问到3节点,所以在反转之前用一个nextNext节点保存3的地址**.
       * 使用三个指针的含义
       cur:当前处理的节点
       next:当前处理节点的下一个节点
       nextNext: 保存反转后的剩余链表
       */
    public ListNode ReverseList(ListNode head) {
        if (head==null)
        {
            return head;
        }
        ListNode cur=head;
        ListNode next=head.next;
        ListNode nextnext=null;
        while(next!=null){
            nextnext=next.next;
            next.next=cur;
            if (cur==head){
                cur.next=null;
            }
            cur=next;
            next=nextnext;
        }
        return cur;
    }
}
```