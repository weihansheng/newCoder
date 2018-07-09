
import java.util.*;
public class Solution45 {
    /**
     *
     创建一个共有n个节点的环形链表,然后每次在这个链表中删除第m个结点
     iterator扫描到尾部是,要吧iterator指向链表表头

     注意: iterator.hasNext() 可判断是否为表尾
     遍历到链表表尾时 将iterator指向表头 iterator=linkedList.iterator()
     */
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

    public static void main(String[] args) {
        Solution45 solution45=new Solution45();
        System.out.println(solution45.LastRemaining_Solution(0,0));
//        List<String> list = new ArrayList<String>();
//        list.add( "0" );
//        list.add( "1" );
//        list.add( "2" );
//        list.add( "3" );
//        list.add( "4" );
//        list.add( "5" );
//        list.add( "6" );
//        list.add( "7" );
//        list.add( "8" );
//        list.add( "9" );
//        list.add( "10" );
//        list.add( "11" );
//        list.add( "12" );
//        list.add( "13" );
//        list.add( "14" );
//        list.add( "15" );
//        list.add( "16" );
//        list.add( "17" );
//        list.add( "18" );
//        list.add( "19" );
//        list.add( "20" );
//
//        int i = 0;
//        Iterator<String> it = list.iterator();
//        while ( it.hasNext() ) {
//            String str = it.next();
//
//            if ( i % 2 == 0 ) {
//                System.out.println( i + "===" + str );
//                it.remove();
//            }
//            i++;
//        }
//
//        for ( String str : list ) {
//            System.out.println( str );
//        }
    }
}
