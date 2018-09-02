public class Solution64 {
    /**
     *这个一个走路径的问题，需要判断这个矩阵中的每一个结点是否可以走一条路径，在走的过程中，
     * 设置一个和矩阵大小相同的整型数组表示是否已经访问，如果某个结点访问了，那么该结点的是否访问则为1。
     * 每次遍历一个结点的时候，递归的方式分别向左、向右、向上、向下
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] flag=new int[matrix.length];
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix,rows,cols,i,j,str,flag,0)){
                    return true;
                }

            }
        }
        return false;
    }

    /**
     *
     * @param matrix 输入矩阵
     * @param rows 矩阵的行数
     * @param cols 矩阵的列数
     * @param i 当前处理的行号
     * @param j 当前处理的列号
     * @param str 要搜索的字符串
     * @param flag 访问标记数组
     * @param k 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     */
    boolean helper(char[] matrix, int rows, int cols, int i,int j,char[] str,int[] flag,int k){
        int index=i*cols+j;
        //i,j超范围，index对应的值不为和字符数组中的不一致，或者该index已经被访问，这些情况只要有符合的就返回false
        //只有上面的所有情况都不符合，也就是值相等，且没有访问过，i,j范围符合
        if (i<0||j<0||i>=rows||j>=cols||matrix[index]!=str[k]||flag[index]==1){
            return false;
        }
        //k==str.length-1时代表存在有str的路径
        if (k==str.length-1){
            return true;
        }
        flag[index]=1;
        //四个方向都去查找
        if (helper(matrix,rows,cols,i-1,j,str,flag,k+1)|| //上
                helper(matrix,rows,cols,i+1,j,str,flag,k+1)||//下
                helper(matrix,rows,cols,i,j-1,str,flag,k+1)||//左
                helper(matrix,rows,cols,i,j+1,str,flag,k+1)//右
                ){
            return true;
        }
        //如果四个方向都没有找到，则把改位置的flag置为0
        flag[index]=0;
        return false;
    }

    public static void main(String[] args) {
        String s="abcesfcsadee";
        char[] matrix=s.toCharArray();
        Solution64 solution64=new Solution64();
        System.out.println(solution64.hasPath(matrix,3,4,"abcb".toCharArray()));
    }
}
