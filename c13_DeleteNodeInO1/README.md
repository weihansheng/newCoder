# newCoder
## 面试题13 在O(1)时间删除链表结点
给定单向链表的头指针和一个结点指针，定义一个函数在0（1）时间删除该结点
```java
        //要确定要删除的结点存在
        /**
         * 三种情况
         * 1. 链表只有一个结点 可直接删除头结点
         * 2. 要删除的结点是尾结点 可直接顺序查找到倒数第二个结点 O(n)
         * 3. 要删除的结点不是尾结点 要删除结点i，现将i的下个结点j的值复制到i，再删除结点j O(1)
         * 总复杂度：[1*O(n)+(n-1)*O(1)]/n=1(1)
         *
         */
        void DeleteNode(ListNode pHead,ListNode pDelete){
            if (pHead==null||pDelete==null)
                return;
            //要删除的结点不是尾结点
            if (pDelete.m_pNext!=null){
                ListNode next=pDelete.m_pNext;
                pDelete.m_nValue=next.m_nValue;
                pDelete.m_pNext=next.m_pNext;
                next=null;
            }
            //只有一个结点
            else if(pDelete==pHead)
            {
                pHead=null;
            }
            //要删除的是尾结点 且有多个结点 直接循环遍历找到倒数第二个节点
            else{
                ListNode node=pHead;
                while (node.m_pNext.m_pNext!=null){
                    node=node.m_pNext;
                }
                node.m_pNext=null;
            }
        }
```
