# Offer 36
## 数组中的逆序对数
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

输入描述:

    题目保证输入的数组中没有的相同的数字
    数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
	
	如输入:1,2,3,4,5,6,7,0 输出7
思路:

 copy位辅助数组,用于存放排序好的数组
          本质就是归并排序,归并的时候记录count值
              合并两个数组时,两个数组的指针从后往前遍历,每次把最大的拷贝到copy中,拷贝的同时计算逆序两个数组之间的逆序数
              如合并a1=[5,7] 和 a2=[4,6]:  只有当a1中的最后一位大于a2中最后一位时才更新count.
              初始count=0,比较a1和a2的最后一位 7>6, 先拷贝7,此时比7小的数位a2中元素个数2,count=count+2;
              此时a1=[5], a2=[4,6], 比较a1和a2的最后一位 6>5, 拷贝6 count不变, 循环以上步骤,直到两个数组遍历完.
              合并之后将copy数组(已排序好)复制到array
    

```java
    int count=0;
    public int InversePairs(int [] array) {
        if (array.length==0||array.length==1){
            return 0;
        }
        mergeSort(array,0,array.length-1);
        return count;
    }
    void mergeSort(int[] array,int start,int end){
        int mid= (end+start)/2;
        if (start<end){
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }
    void merge(int[] array,int start,int mid,int end){
        int[] copy=new int[end-start+1];
        int i1=mid;
        int i2=end;
        int index=copy.length-1;
        while(i1>=start&&i2>=mid+1){
            if (array[i1]>array[i2]){
                count=count+(i2-mid);
                count=count%1000000007;
                copy[index--]=array[i1--];
            }else{
                copy[index--]=array[i2--];
            }
        }
        while (i1>=start){
            copy[index--]=array[i1--];
        }
        while (i2>=mid+1){
            copy[index--]=array[i2--];
        }
        for (int data:copy) {
            array[start++]=data;
        }

    }

```
