package thrityDaysChanllage.LeetCode300;

public class Solution {

    public int lengthOfLIS(int[] nums) {

        int length = nums.length;
        int[] dpArray = new int[length];

        for (int i = 0; i < length; i++) {
            //截至到目前的最长的连续上升子序列长度
            int max_length = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    int temp_length = dpArray[j] + 1;
                    if (temp_length > max_length){
                        max_length = temp_length;
                    }
                }
            }
            dpArray[i] = max_length;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (dpArray[i] > result)
                result = dpArray[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = solution.lengthOfLIS(nums);
        System.out.println(result);
    }

}
