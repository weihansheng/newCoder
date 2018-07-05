# 剑指Offer40
## 数组中只出现一次的数字
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

思路：

    首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
    
    当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后的就是落单的数，因为成对儿出现的都抵消了。
    
    可是题目中有两个数出现一次，我们可以把这两个数分到不同的组，然后在进行上面的操作
    
    依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先将所有的数异或，得到的结果肯定是A、B异或的结果，
    这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，
    根据第3位我们可以把原数组分成两组，即把AB分开，分组标准是第3位是否为1。
    如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
    然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。



注意：

```java
//num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int xorOfAB=0;
        for (int v:array) {
            xorOfAB=xorOfAB^v;
        }
        int indexBit=findFirst1(xorOfAB);
        //将两个数组所有数相互异或
//        num1[0]=0;
//        num2[0]=0;
        for (int v:array) {
            //属于数组A
            if (isBit1(v,indexBit)){
                num1[0]=num1[0]^v;
            }else{
                //属于数组B
                num2[0]=num2[0]^v;
            }
        }
    }
    //找到xorOfAB的二进制表示中第一个1
    private int findFirst1(int xorOfAB){
        int indexBit=0;
        while ((xorOfAB&1)==0&&indexBit<32){
            xorOfAB=xorOfAB>>1;
            indexBit++;
        }
        return indexBit;
    }
    //判断target的第index位是否为1
    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
    //法二：直接用Map记录
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int val:array) {
            if (map.get(val)==null){
                map.put(val,1);
            }else {
                map.put(val,map.get(val)+1);
            }
        }
        int index=1;
        for (Integer key:map.keySet()){
            if (map.get(key)==1){
                if (index==1){
                    num1[0]=key;
                    index++;
                }else {
                    num2[0]=key;
                }
            }
        }
    }

```
