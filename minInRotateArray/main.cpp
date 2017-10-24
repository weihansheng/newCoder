#include <iostream>
#include <vector>

using namespace std;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
//我的思路： 从尾开始往前折半查找  找到首个比末尾值小的位置，从这个位置往前找
//2,2,2,2,2,1,2 不能通过
/*class Solution {
public:
    int minNumberInRotateArray(vector<int> rotateArray) {
        if(rotateArray.size()==0)
            return  0;
        int array_size=rotateArray.size();
        int start=0,end=array_size-1;
        int position=(start+end)/2;
        int min=rotateArray[array_size-1];
        while(rotateArray[position]>rotateArray[array_size-1])
        {
            cout<<"position:"<<position<<endl;
            position=(position+array_size)/2;

        }

        for(int i=position;i>=0;i--){
            if(rotateArray[i]>rotateArray[0]){
                return rotateArray[i+1];
            }
        }
        return rotateArray[position];
    }
};*/
//牛客网友：
class Solution {
public:
    int minNumberInRotateArray(vector<int> array) {
        if (array.size() == 0)
            return 0;
        int low = 0;
        int high = array.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
               high = mid;
            }
        }
        return array[low];
    }
};


int main() {
    vector<int> arrtay={2,2,2,2,2,2,1,2};
    Solution solution;
    cout<<solution.minNumberInRotateArray(arrtay);
    //std::cout << "Hello, World!" << std::endl;
    return 0;
}