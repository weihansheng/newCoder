# leetcode
## workBreak 2
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].

思路：(动态规划问题)
    
         将问题划分为子问题，求s可以划分的句子，可以分为求s[0,i]和s[i+1,n-1]可以划分的句子集合连接 0<i<n；
         每个大问题是基于两个子问题，先求最子问题，自底向上求解
         求解公式:
         f(i)表示s[0,i]可以划分的句子的集合
         f(i)=f(j)+f(j+1，i) 0=<j<i
         初始化f(0)为空是因为当整个单词可分时也满足
    
 注意：s.substring(j,i)为s[j,i-1]

```java


```
