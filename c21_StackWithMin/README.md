# 剑指Offer21
## 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

思路：使用辅助栈记录每次入栈后的最小元素


```java
//使用辅助栈记录每次入栈后的最小元素
    Stack<Integer> s=new Stack<>();
    Stack<Integer> sMin=new Stack<>();

    public void push(int node) {
        if (s.empty()) {
            sMin.push(node);
        }
        else{
            sMin.push(node<sMin.peek()?node:sMin.peek());
        }
        s.push(node);

    }

    public void pop() {
        s.pop();
        sMin.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return sMin.peek();
    }

```
