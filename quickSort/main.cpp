#include <iostream>

using namespace std;

//返回枢值得位置
int partition(int arr[], int left, int right) {
    int tmp = arr[left];
    int i = left, j = right;
    while (i < j) {
        while (i<j&&arr[j] > tmp)
            j--;
        if (i<j&&i < j) {
            arr[i] = arr[j];
            i++;
        }

        while (i<j&&arr[i] < tmp)
            i++;
        if (i<j&&i < j) {
            arr[j] = arr[i];
            j--;
        }

    }
    arr[i] = tmp;
    return i;
}
void  quickSort(int arr[],int left,int right){
    if(left>=right)
        return;
    int j=partition(arr,left,right);
    quickSort(arr,left,j-1);
    quickSort(arr,j+1,right);
}

int main() {
    int arr[7] = {36, 9, -7, 45, 23, 61, 15};
    //cout << "pivot:" << partition(arr, 0, 6) << endl;
    quickSort(arr,0,6);
    for (int i = 0; i <7 ; i++) {
        cout<<arr[i]<<" ";
    }
    return 0;
}