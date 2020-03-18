package LeetCode645;

//Java  100% in time 100% in space
public class Solution2 {

    int count = 0;

    public void isPdstr(String s,int i,int j){
        if(i<0||j>=s.length())
            return;
        if (s.charAt(i) == s.charAt(j)){
            count++;
            isPdstr(s,i-1,j+1);
        }
        else
            return;
    }

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            isPdstr(s,i,i);
            isPdstr(s,i,i+1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String str = "aba";
        int result = solution.countSubstrings(str);
        System.out.println(result);
    }
}
