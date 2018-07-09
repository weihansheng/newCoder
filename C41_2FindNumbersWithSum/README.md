# 剑指Offer41_2
## 和为S的两个数字
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

思路：

     定义两个指针 start end， 初始start指向数组的头，end指向数组尾
     如果array[start]+array[end]>sum end--
     如果array[start]+array[end]<sum start--
     如果array[start]+array[end]=sum 即为所求



```java
public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result= new ArrayList<>();
        int start =0;
        int end =array.length-1;
        while (start<=end){
            int curSum=array[start]+array[end];
            if (curSum<sum){
                start++;
            }else if(curSum>sum){
                end--;
            }else {
                result.add(array[start]);
                result.add(array[end]);
                break;
            }
        }
        return result;
    }

```
