import java.util.Random;

public class Solution26 {
    public static class RandomListNode {
        Random rand=new Random();

        int label;
        int label2=rand.nextInt();
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 思路：
     * 1.克隆节点，把每个节点克隆并放到原节点的后面，其他不变
     * 2.克隆random指针，将克隆节点的random指向原节点的random指针的next
     * 3.拆分链表，把上面得到的链表拆分成原始链表和克隆链表
     * @param pHead
     * @return
     */
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

    public  static  void printRandomList(RandomListNode head){
        while (head!=null){
            System.out.println("node:"+head.label);
            System.out.println("label2:"+head.label2);
            if (head.random!=null){
                System.out.println("random:"+head.random.label);
            }
            head=head.next;

        }
    }

    public static void main(String[] args) {
        RandomListNode node=new RandomListNode(1);
        RandomListNode node2=new RandomListNode(2);
        RandomListNode node3=new RandomListNode(3);
        node3.random=node;
        RandomListNode node4=new RandomListNode(4);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        node.random=node3;
        node2.random=node4;
        node4.random=node4;


//        RandomListNode cloneHead= Clone(node);
        RandomListNode nodeC=new RandomListNode(1);
        nodeC.random=nodeC;
        System.out.println("原链表：");
        printRandomList(node);
        RandomListNode cloneHead= Clone(node);
        System.out.println("克隆链表：");
        printRandomList(cloneHead);
        System.out.println("原链表：");
        printRandomList(node);

    }
}
