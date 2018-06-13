import java.util.ArrayList;
import java.util.Arrays;

public class Solution21 {

    //需考虑每一步打印的条件
    //从左到右 都需要
    //从上到下 至少有两行
    //从右到左 至少有两行三列
    //从下到上 至少有三行两列
    static ArrayList<Integer> printMatrixInCircle(int[][] matrix, int start) {
        ArrayList<Integer> result=new ArrayList<>();
        int endX=matrix.length-start-1;
        int endY=matrix[0].length-start-1;
        for (int i = start; i <=endY; i++) {
            result.add(matrix[start][i]);
        }
        // 从左到右 至少有两行 即需要终止行大于起始行
        if (start<endX) {
            for (int i = start + 1; i <= endX; i++) {
                result.add(matrix[i][endY]);
            }
        }
        //从上到下 至少有两行两列 即需要终止行大于起始行及终止列大于起始列
        if (start<endX&&start<endY) {
            for (int i = endY - 1; i >= start; i--) {
                result.add(matrix[endX][i]);
            }
        }
        //从右到左  至少有三行两列
        if(start+1<endX&&start<endY) {
            for (int i = endX - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }
        return result;
    }
    static public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result=new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0]==null){
            return result;
        }
        int start=0;
        while (start*2<matrix.length&&start*2<matrix[0].length){
            result.addAll(printMatrixInCircle(matrix,start));
            start++;
        }
        return result;

    }

    public static void main(String[] args) {

//        int [][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};
//        int [][] matrix={{1,2},{3,4}};
        int [][] matrix={{1},{2},{3},{4},{5}};
        ArrayList<Integer> result=new ArrayList<>();
        result=printMatrix(matrix);
        System.out.println(result.toString());
    }


}
