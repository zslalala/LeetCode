package thrityDaysChanllage.LeetCode1160;

public class Solution {

    public boolean GetFlag(int[] tempArray,String word){

        for (int i = 0; i < word.length(); i++) {
            int temp_char = word.charAt(i)-'a';
            if (tempArray[temp_char] == 0)
                return false;
            tempArray[temp_char]--;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {

        int chars_length = chars.length();
        int result = 0;

        if(chars_length == 0)
            return 0;

        int[] num_count = new int[26];

        for(int i=0;i<chars_length;++i){
            int temp_char = chars.charAt(i) - 'a';
            num_count[temp_char]++;
        }

        for(int i=0;i<words.length;++i){

            int[] tempArray = num_count.clone();
            boolean flag =  GetFlag(tempArray,words[i]);
            if (flag)
                result += words[i].length();
        }
        return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] words = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        int result = solution.countCharacters(words,chars);
        System.out.println(result);
    }

}
