public class Main {


    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        Solution solution=new Solution();
        TreeNode root=solution.reConstructBinaryTree(pre,in);
        System.out.print("pre:");
        solution.preOrderTraverse(root);
        System.out.print("in:");
        solution.midOrderTraverse(root);


    }
}
