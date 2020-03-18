package LeetCode53;

/***
 * 算法：建立一个maxSumSofar数组，该数组长度与nums相等
 * maxSumSofar[i]存放以nums[i]作为结尾的字串最大值
 * 显然存在状态转移:maxSumSofar[i] = max(maxSumSofar[i-1]+nums[i],nums[i])
 * 获取最大的maxSumSofar即是所求
 */
public class Solution {

    public int maxSubArray(int[] nums) {

        int[] maxSumSofar = new int[nums.length];
        maxSumSofar[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumSofar[i] = Math.max(maxSumSofar[i-1]+nums[i],nums[i]);
            maxSum = Math.max(maxSum,maxSumSofar[i]);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}
