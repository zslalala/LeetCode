package LeetCode198;

public class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        else if(nums.length == 3)
            return Math.max(nums[0]+nums[2],nums[1]);

        int[] maxprofit = new int[nums.length];
        maxprofit[0] = nums[0];
        maxprofit[1] = nums[1];
        maxprofit[2] = nums[0]+nums[2];

        for (int i = 3; i < nums.length; i++) {
            maxprofit[i] = Math.max(maxprofit[i-2]+nums[i],maxprofit[i-3]+nums[i]);
        }
        return Math.max(maxprofit[nums.length-1],maxprofit[nums.length-2]);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,9,3,1};
        int result = solution.rob(nums);
        System.out.println(result);
    }
}
