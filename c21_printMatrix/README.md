# 剑指Offer21
## 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

思路：把矩阵看成由若干圈组成的 每一圈的起始都是左上角的坐标 每一圈有四步

* 从左到右 都需要
* 从上到下 至少有两行
* 从右到左 至少有两行三列
* 从下到上 至少有三行两列


```java
static ArrayList<Integer> printMatrixInCircle(int[][] matrix, int start) {
        ArrayList<Integer> result=new ArrayList<>();
        int endX=matrix.length-start-1;
        int endY=matrix[0].length-start-1;
        for (int i = start; i <=endY; i++) {
            result.add(matrix[start][i]);
        }
        //至少有两行 即需要终止行大于起始行
        if (start<endX) {
            for (int i = start + 1; i <= endX; i++) {
                result.add(matrix[i][endY]);
            }
        }
        //至少有两行两列 即需要终止行大于起始行及终止列大于起始列
        if (start<endX&&start<endY) {
            for (int i = endY - 1; i >= start; i--) {
                result.add(matrix[endX][i]);
            }
        }
        //至少有三行两列
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
```
