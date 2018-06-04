import java.util.ArrayList;

public class Solution {

    //从原链表的头部一个一个取节点并插入到新链表的头部
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



    /*指针反转
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
    static public void printNode(ListNode head){
        ListNode tmp=head;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        printNode(node1);
        ListNode node=solution.ReverseList(node1);
        printNode(node);
    }
}
