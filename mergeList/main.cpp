#include <iostream>
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
using namespace std;

struct ListNode {
    int val;
    struct ListNode *next;

    ListNode(int x) :
            val(x), next(NULL) {
    }
};

//非递归
class Solution {
public:
    ListNode *Merge(ListNode *pHead1, ListNode *pHead2) {
        if (!pHead1 && !pHead2)return NULL;
        if (!pHead1)return pHead2;
        if (!pHead2)return pHead1;
        ListNode *p = new ListNode(0);
        ListNode *tail = p;
        while (pHead1 && pHead2) {
            if (pHead1->val < pHead2->val) {
                tail->next = pHead1;
                pHead1 = pHead1->next;
            } else {
                tail->next = pHead2;
                pHead2 = pHead2->next;

            }
            //更新尾指针
            tail = tail->next;

        }
        if (pHead1)
            tail->next = pHead1;
        if (pHead2)
            tail->next = pHead2;
        return p->next;

    }
};
//递归
class Solution2 {
public:
    ListNode *Merge(ListNode *pHead1, ListNode *pHead2) {
        ListNode *node = NULL;
        if (pHead1 == NULL) { return node = pHead2; }
        if (pHead2 == NULL) { return node = pHead1; }
        if (pHead1->val > pHead2->val) {
            node = pHead2;
            node->next = Merge(pHead1, pHead2->next);
        } else
        {
            node = pHead1;
            node->next = Merge(pHead1->next, pHead2);
        }
        return node;
    }

};

void printList(ListNode *list) {
    ListNode *head = list;
    while (head != NULL) {
        printf("%d ", head->val);
        head = head->next;
    }

}


int main() {
    ListNode *head = NULL, *head2 = NULL;
    for (int i = 1; i < 10; i = i + 2) {
        head = insertTail(head, i);
    }
    for (int i = 1; i < 9; i = i + 2) {
        head2 = insertTail(head2, i);
    }

    printList(head);
    printList(head2);
    ListNode *merge = (ListNode *) malloc(sizeof(ListNode));
    Solution2 solution;
    merge = solution.Merge(head, head2);
    printf("打印merge：");
    printList(merge);
    return 0;
}