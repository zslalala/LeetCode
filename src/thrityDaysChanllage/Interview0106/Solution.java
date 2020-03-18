package thrityDaysChanllage.Interview0106;

public class Solution {

    public String compressString(String S) {

        int length = S.length();

        if (length == 0)
            return "";

        char ch = S.charAt(0);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(ch);
        int count = 0;

        for (int i = 0; i < S.length(); i++) {

            if (ch == S.charAt(i)){
                count++;
                continue;
            }else {
                stringBuilder.append(count);
                ch = S.charAt(i);
                stringBuilder.append(ch);
                count = 1;
            }

        }
        stringBuilder.append(count);
        System.out.println(stringBuilder);

        int length2 = stringBuilder.length();

        if (length2 < length)
            return ""+stringBuilder;
        else
            return S;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String str = "";
        String newstr = solution.compressString(str);
        System.out.println(newstr);
    }

}
