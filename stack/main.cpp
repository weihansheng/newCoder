/*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）*/
#include <iostream>
#include<vector>
#include<stack>
using namespace std;
class Solution {
public:
    bool IsPopOrder(vector<int> pushV,vector<int> popV) {

        stack<int > s;
        int x=0,y=0,n=pushV.size();
        s.push(pushV[0]);
        x=1;
        while (x<n||!s.empty())
        {
            if(!s.empty()&&s.top()==popV[y])
            {
                s.pop();

                y++;
            }else{
                //关键 需要跳出
                if(x==5)
                    break;
                s.push(pushV[x]);
                x++;

            }
        }
        if(x==n&&y==n)
            return 1;
        else
            return 0;

    }
};
int main() {
    vector<int> pushV={1,2,3,4,5};
    vector<int> popV={4,3,5,1,2};
    Solution solution;
    if(solution.IsPopOrder(pushV,popV))
        cout<<"Yes";
    else
        cout<<"NO";
    return 0;
}