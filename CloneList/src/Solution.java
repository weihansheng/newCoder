public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        RandomListNode newHead=new RandomListNode(pHead.label);
        newHead.label=pHead.label;
        newHead.random=pHead.random;
        newHead.next=Clone(pHead.next);

        return newHead;

    }
    public static void main(String[] args){

    }
}
