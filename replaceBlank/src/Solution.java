//请实现一个函数，将一个字符串中的空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class Solution {
    public String replaceSpace(StringBuffer str) {

        for (int i=str.length()-1;i>=0;i--){
            if (str.charAt(i)==' '){
                //System.out.println("空格："+i);
                str.replace(i,i+1,"%20");
            }

        }

        return str.toString();
    }
}


/*题目考查的肯定不是用replace函数啦
        思路是：从左到右遍历，从右到左替换。*/
/*
class Solution {
    public:
    void replaceSpace(char *str,int length) {
        for(int i = 0; i < length; i ++){
            if(*(str+i) == ' '){
                length += 2;
                int j = length -1;
                while(j-2 > i){
                    *(str+j) = *(str+j-2);
                    j--;
                }
                *(str+i) = '%';
                *(str+i+1) = '2';
                *(str+i+2) = '0';
            }
        }
    }*/
