#include <iostream>

using namespace std;

//需考虑指数为负的情况

//牛客网友
//第一种方法：使用递归，时间复杂度O(logn)
//当n为偶数，a^n =（a^n/2）*（a^n/2）
//当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
//举例：
//2^11 = 2^1 * 2^2 * 2^8
//2^1011 = 2^0001 * 2^0010 * 2^1000

//第二种方法：累乘，时间复杂度为O(n)

class Solution {
public:
    double Power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < abs(exponent); i++) {
            result = result * base;
        }
        if (exponent<0)
            return 1/result;
        else
            return result;

    }
};

int main() {
    Solution solution;
    cout << "1的1次方 :" << solution.Power(8.1, -2) << endl;


    return 0;
}