#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};

TreeNode * createTree(vector<int> list,int start){
    if(list[start]=='#')
    {
        return  NULL;
    }
    TreeNode *root=new TreeNode(list[start]);
    int lnode=start*2+1;
    int rnode=start*2+2;
    if (lnode>list.size()-1){
        root->left=NULL;
    }else{
        root->left=createTree(list,lnode);
    }
    if (rnode > list.size() -1) {
        root -> right =NULL;
    }else{
        root -> right = createTree(list, rnode);
    }

    return root;
}
//先序遍历函数
void PreOrderTraverse(TreeNode *T)
{
    if(T)
    {
        cout<<T->val<<" ";
        PreOrderTraverse(T->left);
        PreOrderTraverse(T->right);
    }
    return;
}
//中序遍历函数
void MidOrderTraverse(TreeNode *T)
{
    if(T)
    {

        MidOrderTraverse(T->left);
        cout<<T->val<<" ";
        MidOrderTraverse(T->right);

    }
    return;
}
//后序遍历函数
void PostOrderTraverse(TreeNode *T)
{
    if(T)
    {

        PostOrderTraverse(T->left);
        PostOrderTraverse(T->right);
        cout<<T->val<<" ";
    }
    return;
}
int main() {
    vector<int> datanum = {1,2,3,4,5,'#',6,'#','#',7,8};
    //1,2,3,4,5,'#',6,'#','#',7,8,'#','#','#','#' 后面的#可省略
    TreeNode *t;
    t = createTree(datanum, 0);

    printf("The pre order is : ");
    PreOrderTraverse(t);

    printf("The mid order is : ");
    MidOrderTraverse(t);

    printf("The post order is : ");
    PostOrderTraverse(t);


    return 0;
}