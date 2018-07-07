# 剑指Offer 41
## 和为S的连续整数序列
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

思路：

    用 start和end表示序列的开始和结束
    如果从start到end的和大于sum,我们从序列中去掉较小的值,即start++
    如果从start到end的和小于sum,我们从序列包含更多的数字,即end++
    直到small增加到(1+sum)/2
    
注意:求start到end的和可以根据等差数列前n项和公式S=n*a1+(n*(n-1))/2
    

```java
public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<>();
        int start=1;
        int end=2;
        int S=0;
        while (start<=(sum+1)/2){
            int n=end-start+1;
            int a1=start;
            S=n*a1+(n*(n-1))/2;
            if (S<sum){
                end++;
            }else if(S>sum){
                start++;
            }else {
                //System.out.println("start:"+start+" end:"+end);
                ArrayList<Integer> result=new ArrayList<>();
                for (int i = start; i <=end ; i++) {
                    result.add(i);
                }
                results.add(result);
                start++;
            }
        }
        return results;

    }

```
