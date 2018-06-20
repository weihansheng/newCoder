# 剑指Offer26
## 复杂链表的赋值
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

思路：

     * 1.克隆节点，把每个节点克隆并放到原节点的后面，其他不变
     * 2.克隆random指针，将克隆节点的random指向原节点的random指针的next
     * 3.拆分链表，把上面得到的链表拆分成原始链表和克隆链表

注意：拆分链表时，需要把之前的链断掉  才能通过牛客

```java
public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }
//    1.克隆节点，把每个节点克隆并放到原节点的后面，其他不变
    private static void cloneNodes(RandomListNode pHead) {
        RandomListNode head=pHead;
        while (head!=null){
            RandomListNode clone=new RandomListNode(head.label);
            clone.next=head.next;
            head.next=clone;
            head=clone.next;
        }
    }
//    2.克隆random指针，将克隆节点的random指向原节点的random指针的next
    private static void connectRandomNodes(RandomListNode pHead){
        RandomListNode head=pHead;
        while (head!=null){
            if (head.random!=null){
                head.next.random=head.random.next;
            }
            head=head.next.next;
        }
    }
//    3.拆分链表，把上面得到的链表拆分成原始链表和克隆链表 单号属于原链表，双号属于克隆链表
    private static RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode head=pHead;
        //需要返回头结点 还需要一个临时节点记录头
        RandomListNode cloneHead=null;
        RandomListNode tmp=null;
        if (head!=null){
            tmp=cloneHead=head.next;
            //需要把之前的链断掉  才能通过牛客
            head.next=tmp.next;
            head=head.next;
        }
        while (head!=null){
            tmp.next=head.next;
            tmp=tmp.next;
            head.next=tmp.next;
            head=head.next;

        }
        return cloneHead;
    }
```
