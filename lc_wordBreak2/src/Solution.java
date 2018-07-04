import java.util.*;

public class Solution {
    /**
     *
     思路：(动态规划问题)

     用map把已经求得的结果存起来，避免重复劳动
     将问题划分为子问题，求s可以划分的句子，可以分为求s[0,i]和s[i+1,n-1]可以划分的句子集合连接 0<i<n；
     每个大问题是基于两个子问题，先求最子问题，自底向上求解
     求解公式:
     f(i)表示s[0,i]可以划分的句子的集合  f(i)可能有多个符合条件的句子
     f(i)=f(j)+f(j+1，i) 0=<j<i  当f(j+1，i)不可以划分成句子时 f(i)=""
     特殊测试用例 "aaaaaaa",["aaaa","aaa"]； "a",["a"]

     注意：s.substring(i)为s[i,n-1]  答案为["cats and dog","cat sand dog"] 输出["cat sand dog","cats and dog"]牛客通不过
     */
    //从前往后  也可以从后往前
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        Map<String,ArrayList<String>> f=new HashMap<>();
        ArrayList<String> defaultList = new ArrayList<String>();
        defaultList.add("");
        f.put("",defaultList);
        return getAllPossibleSentences(s,dict,f);
    }
    private ArrayList<String> getAllPossibleSentences(String s, Set<String> dict, Map<String,ArrayList<String>> f){
        if (f.containsKey(s)){
            return f.get(s);
        }
        //第一个list存放的是 原字符串s的
        ArrayList<String> list=new ArrayList<>();
        //遍历每一个符合的前缀单词
        for (String word:dict) {
            if (s.startsWith(word)){
                ArrayList<String> subList=getAllPossibleSentences(s.substring(word.length()),dict,f);
                for (String str : subList) {
                    if ("".equals(str)) {
                        list.add(word);
                    } else {
                        list.add(word+" " + str);
                    }
                }
            }
        }
        f.put(s,list);
        return list;

    }


    public static void main(String[] args) {
        String s="catsanddog";
//        String s="aaaaaaa";
//        String s="a";
        Set<String> dict=new HashSet<String>();
//        dict.add("aaaa");
//        dict.add("aaa");
//        dict.add("a");
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        Solution solution=new Solution();
        System.out.println(solution.wordBreak(s,dict));
        System.out.println("hello".substring(2));
//        System.out.println("cat sand dog".compareTo("cats and dog"));
    }
}
