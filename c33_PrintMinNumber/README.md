# 剑指Offer33
## 把数组排成最小的数
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

思路：

题目实际是希望找到一个排序规则，数组根据这个排序规则排序后能排成一个最小的数字
     给两个数字m和n 需要判断m和n哪个排在前面
     m和n可以拼接成nm和mn
     根据题目要求，若nm<mn 则n应该排在m前面 反之m排在n前面
     
注意：因为mn拼接得到的数字可能超过整数的表达范围，所以本题还隐藏一个大树比较问题，解决大树问题是把整数转为字符串
     
比较两个字符串,依次对比两个字符串中字符的ASC码,两个字符的ASC码相等则继续比较下两个字符直至比较出不同的两个字符跳出方法.方法返回值类型为整型.
     
例如：
     
     String a = "2345";
     
     String b = "2322";
     
     则a.compareTo(b)返回2
     
     b.compareTo(a)返回-2
     
     如果两个字符串相等,则返回值为0



注意：

```java
/**
     题目实际是希望找到一个排序规则，数组根据这个排序规则排序后能排成一个最小的数字
     给两个数字m和n 需要判断m和n哪个排在前面
     m和n可以拼接成nm和mn
     根据题目要求，若nm<mn 则n应该排在m前面 反之m排在n前面
     
     注意：因为mn拼接得到的数字可能超过整数的表达范围，所以本题还隐藏一个大树比较问题，解决大树问题是把整数转为字符串
     
     比较两个字符串,依次对比两个字符串中字符的ASC码,两个字符的ASC码相等则继续比较下两个字符直至比较出不同的两个字符跳出方法.方法返回值类型为整型.
     例如
     String a = "2345";
     String b = "2322";
     则a.compareTo(b)返回2
     b.compareTo(a)返回-2
     如果两个字符串相等,则返回值为0
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==1){
            return String.valueOf(numbers[0]);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int value:numbers) {
            list.add(value);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+""+o2).compareTo(o2+""+o1);
            }
        });
        String result="";
        for (int value:list) {
            result=result+value;
        }
        return result;

    }

```
