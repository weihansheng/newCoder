__author__ = 'Johan007'
# -*- coding:utf-8 -*-
'''
根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果（1除外）。
因此我们可以创建一个数组，里面的数字是排好序的丑数。里面的每一个丑数是前面的丑数乘以2、3 或者5得到的。
那关键就是确保数组里的丑数是有序的了。
开一个大小为index的数组uglyList[index]
初始时uglyList[0]=1; 只有一个丑数，然后将uglyList[0]分别乘以2，3，5；取最小的M=2，然后把M加到丑数数组中。
因为uglyList[0]=1已经乘过2，不需要在计算一次，所以需要将index2加一，依次类推。
'''
class Solution:
    def GetUglyNumber_Solution(self, index):
        if index==0:
            return 0
        uglyList=[]
        uglyList.append(1)
        index2=0
        index3=0
        index5=0
        for i in range(1,index):
            uglyNum = min(uglyList[index2] * 2, uglyList[index3] * 3, uglyList[index5] * 5);
            uglyList.append(uglyNum);
            #更新2 3 5的index
            if uglyNum % 2 == 0:
                index2+=1
            if uglyNum % 3 == 0:
                index3+=1
            if uglyNum % 5 == 0:
                index5+=1
        print uglyList
        return uglyList[index-1]

solution=Solution()
print solution.GetUglyNumber_Solution(5)
