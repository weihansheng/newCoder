public class Solution66 {

    /*
    1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
    返回1 + 4 个方向的探索值之和。
    2.探索时，判断当前节点是否可达的标准为：
    1）当前节点在矩阵内；
    2）当前节点未被访问过；
    3）当前节点满足limit限制
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited=new boolean[rows][cols];
        return helper(threshold,rows,cols,0,0,visited);
    }
    int helper(int threshold, int rows, int cols,int i,int j,boolean[][] visited){
        if (i<0||j<0||i>=rows||j>=cols||visited[i][j]||bitSum(i)+bitSum(j)>threshold){
            return 0;
        }
        visited[i][j]=true;
        return helper(threshold,rows,cols,i-1,j,visited)+
                helper(threshold,rows,cols,i+1,j,visited)+
                helper(threshold,rows,cols,i,j-1,visited)+
                helper(threshold,rows,cols,i,j+1,visited)+1;
    }
    //求一个整数的数位之和
    static int bitSum(int num){
        int sum=0;
        while(num!=0){
            sum=sum+num%10;
            num=num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution66 solution66=new Solution66();
//        System.out.println(bitSum(35));
        System.out.println(solution66.movingCount(3,3,4));

    }
}
