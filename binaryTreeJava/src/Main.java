import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
        int[] datanum = {1,2,3,4,5,'#',6,'#','#',7,8};
        //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
        Solution solution=new Solution();
        TreeNode root;
        root = solution.createTree(datanum, 0);

        System.out.print("The level order is : ");
        solution.printTreeNode(root);

        System.out.print("The pre order is : ");
        solution.preOrderTraverse(root);

        System.out.print("The mid order is : ");
        solution.midOrderTraverse(root);

        System.out.print("The post order is : ");
        solution.postOrderTraverse(root);


    }
}
