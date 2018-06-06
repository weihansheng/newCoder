import java.util.Stack;

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

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println("pop:"+solution.pop());
        solution.push(4);
        System.out.println("pop:"+solution.pop());

    }

}
