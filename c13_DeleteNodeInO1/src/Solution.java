public class Solution {
    public static class ListNode {
        int m_nValue;
        ListNode m_pNext;
        ListNode(int val) {
            this.m_nValue = val;
        }
        ListNode() {

        }
    }
    //要确定要删除的结点存在
    /**
     * 三种情况
     * 1. 链表只有一个结点 可直接删除头结点
     * 2. 要删除的结点是尾结点 可直接顺序查找到倒数第二个结点 O(n)
     * 3. 要删除的结点不是尾结点 要删除结点i，现将i的下个结点j的值复制到i，再删除结点j O(1)
     * 总复杂度：[1*O(n)+(n-1)*O(1)]/n=1(1)
     *
     */
    void DeleteNode(ListNode pHead,ListNode pDelete){
        if (pHead==null||pDelete==null)
            return;
        //要删除的结点不是尾结点
        if (pDelete.m_pNext!=null){
            ListNode next=pDelete.m_pNext;
            pDelete.m_nValue=next.m_nValue;
            pDelete.m_pNext=next.m_pNext;
            next=null;
        }
        //只有一个结点
        else if(pDelete==pHead)
        {
            pHead=null;
        }
        //要删除的是尾结点 且有多个结点 直接循环遍历找到倒数第二个节点
        else{
            ListNode node=pHead;
            while (node.m_pNext.m_pNext!=null){
                node=node.m_pNext;
            }
            node.m_pNext=null;
        }
    }
    void printList(ListNode pHead){
        ListNode node=pHead;
        while (node!=null){
            System.out.println(node.m_nValue);
            node=node.m_pNext;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.m_pNext=node2;
        node2.m_pNext=node3;
        node3.m_pNext=node4;
        Solution solution=new Solution();
        solution.printList(node1);
        solution.DeleteNode(node1,node2);
        solution.printList(node1);
    }
}
