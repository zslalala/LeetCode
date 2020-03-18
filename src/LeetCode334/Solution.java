package LeetCode334;

public class Solution {

    public boolean increasingTriplet(int[] nums) {

        int num1 = Integer.MAX_VALUE,num2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= num1){
                num1 = nums[i];
                continue;
            }

            if (nums[i] <= num2){
                num2 = nums[i];
                continue;
            }

            return true;

        }

        return false;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5};
        boolean flag = solution.increasingTriplet(nums);
        System.out.println(flag);

    }

}
