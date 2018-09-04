# leetcode 
## Candy

N个孩子站成一排，每个孩子分配一个分值。给这些孩子派发糖果，满足如下要求：
* 每个孩子至少一个
* 分值更高的孩子比他的相邻位的孩子获得更多的糖果
* 求至少分发多少糖果？


思路：

* 从左向右扫描，保证一个方向上分数更大的糖果更多
* 从右向左扫描，保证另一个方向上分数更大的糖果更多


注意：

```java
static public int candy(int[] ratings) {
        int length=ratings.length;
        if (length==1) {
            return 1;
        }
        int[] v=new int[length];
        //初始将每个孩子的糖果数都设为1
        for (int i = 0; i <length ; i++) {
            v[i]=1;
        }
        //从左向右扫描，保证一个方向上分数更大的糖果更多
        for (int i = 1; i <length ; i++) {
            if (ratings[i]>ratings[i-1]){
                v[i]=v[i-1]+1;
            }
        }
        //从右向左扫描，保证另一个方向上分数更大的糖果更多
        for (int i = length-2; i >=0 ; i--) {
            //当ratings[i]>ratings[i+1]时，如果v[i]已经比v[i]大就没必要再加
            if (ratings[i]>ratings[i+1]&&v[i]<=v[i+1]){
                v[i]=v[i+1]+1;
            }
        }
        int sum=0;
        for (int value:v) {
            sum+=value;
//            System.out.println(value);
        }
        return sum;
    }

```
