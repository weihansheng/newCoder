#include <iostream>
#include <vector>
using namespace std;
//从尾到头打印链表 不能使用两个vector（超内存）
//输入一个链表，从尾到头打印链表每个节点的值
  struct ListNode {
        int val;
        struct ListNode *next;
        ListNode(int x) :
              val(x), next(NULL) {
        }
  };
class Solution {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> tail2head;

        while(head!=NULL)
        {
            tail2head.push_back(head->val);
            head=head->next;
        }
        int n,tmp;
        if (tail2head.size()%2==0)
            n=tail2head.size()/2;
        else
            n=(tail2head.size()-1)/2;

        for (int i = 0; i <n ; i++) {
            tmp=tail2head[i];
            tail2head[i]=tail2head[tail2head.size()-1-i];
            tail2head[tail2head.size()-1-i]=tmp;
        }
        return tail2head;
    }
};
int main() {
    vector<int > tail2head;
    for (int i = 0; i <20 ; i++) {
        tail2head.push_back(i);
    }
    for (int i = 0; i <tail2head.size() ; i++) {
        cout<<tail2head[i];
    }
    cout<<endl;
    int n,tmp;
    if (tail2head.size()%2==0)
        n=tail2head.size()/2;
    else
        n=(tail2head.size()-1)/2;
    cout<<"n="<<n<<endl;

    for (int i = 0; i <n ; i++) {
        tmp=tail2head[i];
        tail2head[i]=tail2head[tail2head.size()-1-i];
        tail2head[tail2head.size()-1-i]=tmp;
    }
    for (int i = 0; i <tail2head.size() ; i++) {
        cout<<tail2head[i];
    }
    return 0;
}