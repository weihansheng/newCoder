import java.util.*;

public class Solution60 {
    static public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 序列化二叉树时，根据前序遍历方式将二叉树节点的值转换为字符串，如果二叉树节点为空，则以‘#’代替，每个节点的值以‘，’分隔，
     * 反序列化时，以前序遍历方式从队列中取出数值构建二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuffer s=new StringBuffer();
        if (root==null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val);
        s.append(',');
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();

    }
    TreeNode Deserialize(String str) {
        if (str.equals("#")) {
            return null;
        }
        String[] arr=str.split(",");
        Queue<String> q=new LinkedList<>();
        for (String s:arr) {
            q.add(s);
        }
        TreeNode root=preOrder(q);
        return root;
    }
    TreeNode preOrder(Queue<String> q){
        String s=q.remove();
        if (s.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(s));
        node.left=preOrder(q);
        node.right=preOrder(q);
        return node;
    }

    public static void main(String[] args) {
        Solution60 solution59=new Solution60();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        node4.right=node6;
        String str=solution59.Serialize(node1);
        System.out.printf(str);
        TreeNode root=solution59.Deserialize(str);
        System.out.println("   ");
    }
}
