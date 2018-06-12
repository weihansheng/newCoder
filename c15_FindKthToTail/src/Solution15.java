public class Solution15 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
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

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(FindKthToTail(node1,1).val);

    }
}
