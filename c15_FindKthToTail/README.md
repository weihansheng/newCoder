# 剑指Offer15
## 链表中倒数第k个结点
输入一个链表，输出该链表中倒数第k个结点。

思路：用两个指针i，j；i先走k-1个结点后j开始走，j就是倒数第k个



```java
//思路：用两个指针i，j；i先走k-1个结点后j开始走，j就是倒数第k个
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head==null||k==0)
            return null;
        ListNode node1=head;
        ListNode nodeK;

        for (int i = 0; i <k ; i++) {
            //考虑k大于链表长度的情况
            if (node1==null)
                return null;
            node1=node1.next;
        }
        nodeK=head;
        while (node1!=null){
            nodeK=nodeK.next;
            node1=node1.next;
        }
        return nodeK;
    }
```
