# newCoder
### 用两个栈实现队列
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。。
```java
/*
* 解题思路： 
* 入队：将元素进栈A
  出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并同时push进栈B，栈B出栈； 如果B不为空，栈B直接出栈。
  */
public String PrintMinNumber(int [] numbers) {
        if (numbers.length==1)
            return String.valueOf(numbers[0]);
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            arrayList.add(numbers[i]);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        String result="";
        for (int i:arrayList){
            result=result+i;
        }
        return result;

    }
```