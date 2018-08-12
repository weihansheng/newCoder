import java.util.*;
public class Solution54 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     //左神讲的
     //先说个定理：两个指针一个fast、一个slow同时从一个链表的头部出发
     //fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
     //此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
     //这次两个指针一次走一步，相遇的地方就是入口节点。
     //这个定理可以自己去网上看看证明。
     https://blog.csdn.net/snow_7/article/details/52181049
     */

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast==null||fast.next==null)
            return null;
        fast=pHead;
        while(fast!=null&&fast.next!=null){
            if (slow==fast){
                return slow;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        ListNode node=pHead;
        HashSet<ListNode> set=new HashSet<>();
        while(node!=null){
            if (!set.add(node)){
                return node;
            }
            node=node.next;
        }
        return null;

    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node3;
        Solution54 solution54=new Solution54();
        System.out.println(solution54.EntryNodeOfLoop2(node1).val);

//        HashMap<ListNode,Integer> hashMap=new HashMap<>();
//        hashMap.put(node1,10);
//        hashMap.put(node2,10);
//        hashMap.put(node3,10);
//        System.out.println(hashMap.getOrDefault(node1,1));
//        System.out.println(hashMap.getOrDefault(node2,2));
//        System.out.println(hashMap.getOrDefault(node3,3));


    }
}
