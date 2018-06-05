import java.util.ArrayList;

public class Solution {
    /**
     * 输入两个链表，找出它们的第一个公共结点
     */
    /**
     * 分析：两个单链表如果存在第一个公共结点，则后续结点一定都公共，
     因为结点里包含next指针，如果第一个公共结点相同，则next必然相同，
     所以第一个公共结点后链表合并。
     */
    /**
     * 思路：找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
     （因为2个链表用公共的尾部）
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null){
            return null;
        }
        ListNode cNode=null;
        ArrayList<Integer> list=new ArrayList<>();
        while(pHead1!=null){
            list.add(pHead1.val);
            pHead1=pHead1.next;
        }
        while(pHead2!=null){
            if (list.contains(pHead2.val)) {
                return pHead2;
            }
            pHead2=pHead2.next;
        }

        return cNode;
    }
    public int findListLength(ListNode node){
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null){
            return null;
        }
        ListNode cNode=null;
        int length1=findListLength(pHead1);
        int length2=findListLength(pHead2);
        if (length1<length2){
            for (int i = 0; i < length2-length1; i++) {
                pHead2=pHead2.next;
            }
        }else{
            for (int i = 0; i < length1-length2; i++) {
                pHead1=pHead1.next;
            }
        }
        while (pHead1!=null){
            if (pHead1==pHead2) {
                return pHead1;
            }
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }

        return cNode;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;

        ListNode cNode=solution.FindFirstCommonNode(node1,node2);
        if (cNode!=null){
            System.out.println(cNode.val);
        }

    }

}
