# 剑指Offer22
## 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

思路：
* 如果下一个弹出的数字刚好在栈顶，则直接弹出
* 如果下一个弹出的数字不在栈顶，把入栈序列中还没有入栈的数字压入栈，直到下一个弹出的数字压入栈顶。
* 如果所有的数字都压入了栈都没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列

注意：

```java
static public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0||popA.length==0||pushA.length!=popA.length) {
            return false;
        }
        int push=0;
        int pop=0;
        Stack<Integer> stack=new Stack<>();
        boolean result=false;
        while (push<=pushA.length&&pop<popA.length){
            if (!stack.empty()){
                if (stack.peek()==popA[pop]) {
                    stack.pop();
                    pop++;
                }else{
                    if (push<pushA.length){
                        stack.push(pushA[push]);
                        push++;
                    }else {
                        return false;
                    }

                }
            }else{
                stack.push(pushA[push]);
                push++;
            }

        }
        if (push==pushA.length&&pop==popA.length){
            result=true;
        }
        return result;
    }

```
