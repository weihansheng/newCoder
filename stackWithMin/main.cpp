#include <iostream>
//栈中元素可能弹出，当最小元素作为栈顶元素弹出后，此时的最小元素已不再栈中
//所以需要一个专门存储最小元素的栈
using namespace std;
class Solution {
public:
    int count=0;
    int s[999999];
    int min_s[999999];
    void push(int value) {
        s[count]=value;
        if(count==0)
            min_s[0]=s[0];

        else {
            if (value <= min_s[count - 1])
                min_s[count] = value;
            else
                min_s[count] = min_s[count - 1];
        }
        count++;


    }
    void pop() {
        if(count>0)
            count--;
    }
    int top() {
            return s[count-1];
    }
    int min() {
            return min_s[count-1];

    }
};
int main() {
   Solution solution;
    solution.push(1);
    solution.push(10);
    solution.push(5);
    solution.push(3);
    solution.push(9);
    cout<<solution.min();
    return 0;
}