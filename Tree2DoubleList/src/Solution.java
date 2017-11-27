public class Solution {

    public   TreeNode  createTree(int[] list,int start){
        if(list[start]=='#')
        {
            return  null;
        }
        TreeNode root=new TreeNode(list[start]);
        int lNode=start*2+1;
        int rNode=start*2+2;
        if (lNode>list.length-1){
            root.left=null;
        }else{
            root.left=createTree(list,lNode);
        }
        if (rNode > list.length -1) {
            root.right =null;
        }else{
            root.right = createTree(list, rNode);
        }

        return root;
    }
    /**
     * 先序遍历函数
     * 若非递归使用栈
     **/
    public  void preOrderTraverse(TreeNode T)
    {
        if(T!=null)
        {
            System.out.print(T.val+" ");
            preOrderTraverse(T.left);
            preOrderTraverse(T.right);
        }
    }


    //last用于记录上一个节点
    TreeNode last=null;
    public  void ConvertHelper(TreeNode cur){
        if(cur==null){
            return;
        }
        ConvertHelper(cur.left);
//        当前节点的左节点是上一个节点
        cur.left=last;
        if (last!=null){
            last.right=cur;
        }
        last=cur;
        ConvertHelper(cur.right);
    }

//    返回双链表头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ConvertHelper(pRootOfTree);

        TreeNode tmp=pRootOfTree;
        while(tmp.left!=null){
            tmp=tmp.left;
        }
        return tmp;
    }
    static  public  void  main(String arg[]){
        int[] datanum = {10,6,14,4,8,12,16,'#','#','#',9,11};
        //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
        Solution solution=new Solution();
        TreeNode root;
        root = solution.createTree(datanum, 0);
        solution.preOrderTraverse(root);
        System.out.println();
        TreeNode list=solution.Convert(root);
        while(list!=null){
            System.out.print(list.val+" ");
            list=list.right;
        }
    }
}


//class Solution {
//    public:
//                TreeNode* Convert(TreeNode* pRootOfTree)
//    {
//        if(pRootOfTree == nullptr) return nullptr;
//        TreeNode* pre = nullptr;
//         
//        convertHelper(pRootOfTree, pre);
//         
//        TreeNode* res = pRootOfTree;
//        while(res ->left)
//            res = res ->left;
//        return res;
//    }
//     
//            void convertHelper(TreeNode* cur, TreeNode*& pre)
//    {
//        if(cur == nullptr) return;
//         
//        convertHelper(cur ->left, pre);
//         
//        cur ->left = pre;
//        if(pre) pre ->right = cur;
//        pre = cur;
//         
//        convertHelper(cur ->right, pre);
//         
//         
//         
//    }
//};