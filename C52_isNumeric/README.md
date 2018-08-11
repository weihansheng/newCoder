# 剑指Offer 52
## 表示数值的字符串
题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。


思路：
        
      1.正则表达式匹配
      2.多个条件判断
    
注意：

```java
public boolean isNumeric(char[] str) {
        String string=String.copyValueOf(str);
        return string.matches("[\\+|\\-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
    public boolean isNumeric2(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i <str.length ; i++) {
            char c=str[i];
            if (c=='+'||c=='-'){
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign&&i>0&&str[i-1]!='E'&&str[i-1]!='e')
                    return false;
                //第二次出现+-,一定在e之后
                if (sign&&str[i-1]!='E'&&str[i-1]!='e')
                    return false;
                sign=true;

            }else if(c=='e'||c=='E'){
                //e后面一定要有数字
                if (i==str.length-1)
                    return false;
                //不能有两个e
                if (hasE)
                    return false;
                hasE=true;
            }else if (c=='.'){
                //e后面不能有小数点，小数点不能出现两次
                if (hasE||decimal)
                    return false;
                decimal=true;
            }else{
                // 不合法字符
                if (c<'0'||c>'9')
                    return false;
            }
        }
        return true;
    }

```
