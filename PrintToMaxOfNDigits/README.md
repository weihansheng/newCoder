# newCoder
## 打印1到最大的n位数
输入数字n,按顺序打印出从1到最大的n位十进制数. 比如输入3,则打印出1,2,3一直到最大的3位数999
```java
    //解法一: 使用数组存储整数, Increment每次加1
    //解法二:每一位都可能是0-9中的一个数,相当于n位0-9的全排列 可使用递归实现
    public void PrintToMaxOfNDigits(int n){
        int[] array=new int[n];
        if (n<=0)
            return;
        while (!Increment(array)){
            printArray(array);
        }

    }
    boolean Increment(int[] array){
        //isOverFLow用于标识是否已到99999...
        boolean isOverFLow=false;
        //nTakeOver用与记录进位
        int nTakeOver=0;
        for (int i = array.length-1; i >=0 ; i--) {
            int nSum=array[i]+nTakeOver;
            if (i==array.length-1)
                nSum++;
            //大于10需要向上进一位
            if (nSum>=10){
                if (i==0) {
                    isOverFLow = true;
                }else {
                    nSum=nSum-10;
                    nTakeOver=1;
                    array[i]=nSum;
                }

            }else {
                array[i]=nSum;
                break;
            }
        }
        return isOverFLow;
    }
    //数组前面的0不需要打印出来
    void printArray(int[] array){
        boolean isFisrt0=true;
        for (int i = 0; i < array.length; i++) {
            if (isFisrt0&&array[i]!=0)
                isFisrt0=false;
            if (!isFisrt0)
                System.out.print(array[i]);
        }
        System.out.println();
    }
    public void PrintToMaxOfNDigits2(int n){
        int[] array=new int[n];
        if (n<=0)
            return;
        for (int i = 0; i < 10; i++) {
            array[0]=i;
            PrintToMaxOfNDigitsRecursively(array,0);
        }

    }
    public void PrintToMaxOfNDigitsRecursively(int[] array,int index){
        if (index==array.length-1)
            printArray(array);
        else {
            for (int i = 0; i <10 ; i++) {
                array[index+1]=i;
                PrintToMaxOfNDigitsRecursively(array,index+1);
            }
        }
    }
```
