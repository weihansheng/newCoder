public class Solution17 {
    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
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

    static public void printNode(ListNode head){
        ListNode tmp=head;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(9);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node7.next=node7;
        printNode(Merge(node1,node3));

    }
}
