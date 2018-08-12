

public class Solution53 {
    int[] hash=new int[256];
    StringBuffer string=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        string.append(ch);
        hash[ch]++;

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for (char c: string.toString().toCharArray()) {
            if (hash[c]==1){
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution53 solution53=new Solution53();
        String str="google";
        for (char c:str.toCharArray()) {
            solution53.Insert(c);
        }
        System.out.println(solution53.FirstAppearingOnce());
    }
}
