#include <iostream>
#include <vector>
//链表中倒数第k个结点
//输入一个链表，输出该链表中倒数第k个结点。
//个人认为主要考察边界条件
using namespace std;
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if(pListHead==NULL||k<1)
            return NULL;
        vector<ListNode *> s;
        while(pListHead){
            s.push_back(pListHead);
            pListHead=pListHead->next;
        }
        //cout<<s[s.size()-k-1]->val<<s[s.size()-k-1]->next;
        if(k>s.size())
            return NULL;
        return s[s.size()-k];

    }
};
void printList(ListNode *list){
    ListNode *head=list;
    while(head) {
        printf("%d ", head->val);
        head = head->next;
    }

}
int main() {
    ListNode *head=(ListNode*)malloc(sizeof(ListNode));
    head->val=0;
    ListNode *p=head;
    for (int i = 1; i <10 ; i++) {
        ListNode *node=(ListNode*)malloc(sizeof(ListNode));
        node->val=i;
        node->next=NULL;
        p->next=node;
        p=node;
    }
    printList(head);
//    while(head){
//        printf("%d ",head->val);
//        head=head->next;
//    }
    Solution solution;
    ListNode *node=solution.FindKthToTail(head,1);
    cout<<"倒数："<<node->val;
    return 0;
}