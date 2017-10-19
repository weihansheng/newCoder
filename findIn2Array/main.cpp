#include <iostream>
#include <vector>

using namespace std;
/*在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/
//注意可以是长方形矩阵
/* 牛客网友思路
* 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
* 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
* 要查找数字比左下角数字小时，上移
*/
class Solution {
public:
    bool Find(int target, vector<vector<int> > array) {

        //行数
        int m=array.size();
        //列数
        int n=array[0].size();
        int i=m-1;
        int j=0;
        while(i>=0&&j<=n-1){
            if (array[i][j]==target)
                return true;
            else if(array[i][j]>target)
                    i--;
            else
                j++;
        }
        return false;

    }
};
int main() {
    vector<vector<int>> array(1);
    //array={{1,2,3,4,5},{6,7,8,9,10}};
    array={{1,2,3,4,5}};
    //cout<<array.size()<<endl;
    Solution solution;
    cout<<solution.Find(5,array);
    return 0;
}