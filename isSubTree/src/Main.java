public class Main {
    public static  void main(String[] args){
        int[] datanum = {1,2,3,4,5,'#',6,'#','#',7,8};
        //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
        Solution solution=new Solution();
        TreeNode root;
        root = solution.createTree(datanum, 0);
        int[] tree2={5,7,8};
        TreeNode root2=solution.createTree(tree2,0);
        System.out.print("B是否是A的子树："+solution.HasSubtree(root,root2));
    }
}
