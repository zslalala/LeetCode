package SubSequenece.LeetCode1332;

public class Solution {

    public int removePalindromeSub(String s) {

        if (s.length() == 0)
            return 0;

        for (int i = 0,j = s.length() - 1; i <= j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)){
                return 2;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String str = "ababa";
        int result = solution.removePalindromeSub(str);
        System.out.println(result);


    }

}
