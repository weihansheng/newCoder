# 剑指Offer49
## 数组中重复的数字

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

思路：

    用一个数组记录每个数字出现的次数



注意：

    考虑数组为空或没有元素的情况

```java
/**
     *
     * @param numbers an array of integers
     * @param length the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     *                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * @return true if the input is valid, and there are some duplications in the array number
                        ,otherwise false
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||numbers.length<=0) {
            duplication[0] = -1;
            return false;
        }
        int count[]=new int[length];
        for (int num:numbers) {
            count[num]++;
            if (count[num]>1)
            {
                duplication[0]=num;
                return true;
            }
        }
        return false;
    }

```
