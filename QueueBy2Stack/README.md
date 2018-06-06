# newCoder
### 用两个栈实现队列
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。。
```java
/*
* 解题思路： 
* 入队：将元素进栈A
  出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并同时push进栈B，栈B出栈； 如果B不为空，栈B直接出栈。
  */
public class Solution {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            System.out.println("队列为空");
        }
        return stack2.pop();
    }
}

```