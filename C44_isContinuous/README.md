# 剑指Offer44
## 扑克牌顺子
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。

思路：

     第一步：将数组排序
     第二步：遍历数组，统计0的个数，同时记录非零元素
     第三遍：统计非零元素之间的空缺的总数，如果总数<=0的个数 返回true 否则返回false
    
注意：如果有两个元素相同 即有对子 则可返还false


```java
public boolean isContinuous(int [] numbers) {
        if (numbers.length<5)
            return false;
        Arrays.sort(numbers);
        int numberof0=0;
        ArrayList<Integer> listNot0=new ArrayList<>();
        for (int n:numbers) {
            if (n==0)
            {
                numberof0++;
            }else {
                if (listNot0.contains(n)){
                    return false;
                }else {
                    listNot0.add(n);
                }
            }
        }
        int gap=0;
        for (int i = 0; i <listNot0.size()-1 ; i++) {
            gap+=listNot0.get(i+1)-listNot0.get(i)-1;
        }
        if (numberof0-gap>=0){
            return true;
        }else {
            return false;
        }
    }

```
