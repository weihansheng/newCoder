import java.util.Stack;

public class Solution22 {
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

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
//        int[] popA={4,5,3,2,1};
        int[] popA={4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
