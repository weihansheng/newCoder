
import java.util.*;

public class Solution56 {
    static public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    List<TreeLinkNode> list=new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode cur=pNode;
        TreeLinkNode root=pNode;
        while (pNode.next!=null){
            pNode=pNode.next;
            root=pNode;
        }
        MidOrderTraverse(root);
        TreeLinkNode target=null;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i)==cur){
                if (i<list.size()-1)
                    target= list.get(i+1);
                else
                    target =null;
                break;
            }
        }
        return target;
    }
    //中序遍历函数
    void MidOrderTraverse(TreeLinkNode node)
    {
        if(node!=null)
        {
            MidOrderTraverse(node.left);
            list.add(node);
            MidOrderTraverse(node.right);
        }
        return;
    }

    public static void main(String[] args) {
        Solution56 solution56=new Solution56();
        TreeLinkNode node1=new TreeLinkNode(1);
        TreeLinkNode node2=new TreeLinkNode(2);
        TreeLinkNode node3=new TreeLinkNode(3);
        TreeLinkNode node4=new TreeLinkNode(4);
        TreeLinkNode node5=new TreeLinkNode(5);
        TreeLinkNode node6=new TreeLinkNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node2.next=node1;
        node3.next=node1;
        node3.next=node2;
        node5.next=node3;
        node6.next=node3;
        System.out.println(solution56.GetNext(node1).val);

    }

}
