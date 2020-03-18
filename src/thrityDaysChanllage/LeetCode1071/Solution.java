package thrityDaysChanllage.LeetCode1071;

public class Solution {

    //辗转相除法，无论m，n谁大，每次都会把大的给m，小的给n，最后时m为结果，n为0
    public int GetGCD(int m,int n){

        int result = 0;
        while (n != 0){
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    public boolean isSubstr(String str,String substr){

        int strlength = str.length();
        int substrlength = substr.length();

        int times = strlength / substrlength;

        String newstr = "";

        for (int i = 0; i < times; i++) {
            newstr += substr;
        }

        if (newstr.equals(str))
            return true;
        else
            return false;

    }

    public String gcdOfStrings(String str1, String str2) {

        int length1 = str1.length();
        int length2 = str2.length();

        if (length1 == 0 || length2 == 0){
            return "";
        }

        int gcd = GetGCD(length1,length2);

        String substr = str1.substring(0,gcd);

        boolean flag1 = isSubstr(str1,substr);
        boolean flag2 = isSubstr(str2,substr);

        if (flag1 && flag2)
            return substr;
        else
            return "";
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String substr = solution.gcdOfStrings("ABCABC","ABC");
        System.out.println(substr);
    }
}
