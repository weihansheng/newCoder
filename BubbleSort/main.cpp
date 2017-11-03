#include <iostream>
using namespace std;
void BubbleSort(int arr[]){
    //arr（0..n-1)是待排序的文件，采用自下向上扫描，对arr做冒泡排序 每一趟排序都使有序区增加了一个气泡
    int n=10;
    bool exchange;//交换标志
    for (int i = 0; i < n; i++) {//最多做n-1趟排序
        exchange= false;//本趟排序开始前，交换标志应为假
        for (int j = n-1; j >i; j--) {//对当前无序区R[i..n-1]自下向上扫描
            if (arr[j]<arr[j-1])
            {
                int tmp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
                exchange= true;//发生了交换，故将交换标志置为真
            }
        }
        if (!exchange)//本趟排序未发生交换，可以提前终止算法
            return;
    }
}
int main() {
    int a[10]={2,3,1,8,5,4,7,6,9,0};
    BubbleSort(a);
    for (int i = 0; i < 10; i++) {
        cout<<a[i]<<" ";
    }
    return 0;
}