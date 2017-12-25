# newCoder
### 第一个只出现一次的字符
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
```java
/***
     * 时间复杂度O(n+52)
     * count数组用来存在每个字符出现的次数
     * count大小为52，因为Z-a中间有几个符号，所以多开一些
     * position数组用来记录每个字符第一次出现的位置以为有52个字符 开52个即可
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0)
            return -1;
        int[] position = new int[60];
        int[] count = new int[60];
        char[] chars = str.toCharArray();
        int m = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]-65] == 0) {
                count[chars[i]-65] = 1;
                position[m++] = i;
            } else {
                count[chars[i]-65]++;
            }
        }
        for(int i=0;i<position.length;i++){
            if (count[chars[position[i]]-65]==1){
                return position[i];
            }
        }
        return 0;
    }
    ```