import java.util.HashMap;

public class Solution55 {
    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**

    非递归的代码：
            1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
            2.设置 pre ，cur 指针， pre指针指向当前确定不重复的那个节点，而cur指针相当于工作指针，一直往后面搜索。
     */
    public ListNode deleteDuplication2(ListNode pHead)
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

    public static void main(String[] args) {
        Solution55 solution55=new Solution55();
//        int[] array={1,2,2,4,5,6,6,7,7};
        int[] array={1,1,1,1,1};
        ListNode head=new ListNode(1);
        ListNode node=head;
        for (int c:array) {
            ListNode newnode=new ListNode(c);
            node.next=newnode;
            node=node.next;
        }
        head=solution55.deleteDuplication(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
