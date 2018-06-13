import java.util.Stack;

public class Solution21 {

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

    public static void main(String[] args) {
        Solution21 solution21=new Solution21();
        solution21.push(3);
        System.out.println(solution21.min());
        solution21.push(4);
        System.out.println(solution21.min());
        solution21.push(2);
        System.out.println(solution21.min());
        solution21.push(1);
        System.out.println(solution21.min());
        solution21.pop();
        System.out.println(solution21.min());
        solution21.pop();
        System.out.println(solution21.min());
        solution21.push(0);
        System.out.println(solution21.min());
    }
}
