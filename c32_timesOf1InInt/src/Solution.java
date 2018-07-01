public class Solution {
    //求出1...n中x出现的次数
    //解法，分别求每一位上1出现的次数，然后相加
    //设一个m位的数:abcdef , cur为要求的第t位上的数字，
    // before为第t位(从右至左)之前的数字表示的数，after表示第t位之后的数字表示的数
    //即 n = before*Math.pow(10,t)+cur*Math.pow(10,t-1)+after
    //当 cur < x ; count(t) = before*Math.pow(10,t-1)
    //当 cur == x ; count(t) = before*Math.pow(10,t-1) + after +1
    //当 cur > x ; count(t) = (before+1)*Math.pow(10,t-1)
//    public int NumbersOfXBetweenXAndN(int n, int x) {
//        int count = 0;
//        int i = 1;
//        int currrent = 0, after = 0, before = 0;
//        while ((n / i) != 0) {
//            currrent = (n / i) % 10;
//            before = (n / i) / 10;
//            after = n - (n / i) * i;
//            if (currrent < x) {
//                count += before * i;
//            } else if (currrent == x) {
//                count += before * i + after + 1;
//            } else {
//                count += (before + 1) * i;
//            }
//            i *= 10;
//        }
//        return count;
//    }

    //当 cur < x ; count(t) = before*Math.pow(10,t-1)
    //当 cur == x ; count(t) = before*Math.pow(10,t-1) + after +1
    //当 cur > x ; count(t) = (before+1)*Math.pow(10,t-1)
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        int before,current,after;
        //i用来记录到了哪一位数
        int i=1;
        while(n/i>0){
            before=(n/i)/10;
            current=(n/i)%10;
            after=n-before*(i*10)-current*i;
            //小于1时 由更高位before决定
            if (current<1){
                count=count+before*i;

            }
            //不仅受更高位影响，还受低位影响
            else if(current==1){
                count=count+before*i+after+1;
            }
            //由更高位和当前位决定
            else{
                count=count+(before+1)*i;
            }
            i=i*10;
        }

        return count;
    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(100));
    }

}
