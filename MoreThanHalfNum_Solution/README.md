# newCoder
### 数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
```java
/**
     *思路：
     *用一个数组分别记录每个数字出现的次数，和出现次数最大的数字（也可以用一个int） 时间复杂度O(n)
     * 也可根据数学知识，如果存在个数大于n/2，则排序后的第n/2个数组一定是该数，遍历数组记录该数出现的个数
     */
public int MoreThanHalfNum_Solution(int [] array) {
        int[] a =new int[array.length+1];
        int maxNum=0;
        int maxInt=array[0];
        for (int i=0;i<array.length;i++)
        {
            a[array[i]]++;
            if (a[array[i]]>maxNum) {
                maxNum = a[array[i]];
                maxInt=array[i];
            }
        }
        if (maxNum<=array.length/2) {
            maxInt=0;
        }
        return maxInt;
    }
```