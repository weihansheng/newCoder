# 剑指Offer45
## 圆圈中最后剩下的数
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)


思路：

     创建一个共有n个节点的环形链表,然后每次在这个链表中删除第m个结点
     iterator扫描到尾部是,要吧iterator指向链表表头

注意: 
     iterator.hasNext() 可判断是否为表尾
     遍历到链表表尾时 将iterator指向表头 iterator=linkedList.iterator()
    


```java
public int LastRemaining_Solution(int n, int m) {
        if (n==0||m==0)
            return -1;
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            linkedList.add(i);
        }
        Iterator<Integer> iterator=linkedList.iterator();
        while (linkedList.size()>1){
            for (int i = 0; i <m ; i++) {
                if (iterator.hasNext()){
                    iterator.next();
                }else {
                    iterator=linkedList.iterator();
                    iterator.next();
                }
            }
            iterator.remove();
        }
        return linkedList.get(0);
    }
```
