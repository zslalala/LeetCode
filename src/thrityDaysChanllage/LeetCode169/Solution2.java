package thrityDaysChanllage.LeetCode169;

import java.util.HashMap;

public class Solution2 {

    //摩尔计数法
    public int majorityElement(int[] nums) {

        int sum = 0;
        int nowInt = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nowInt == nums[i]){
                sum++;
            }else{
                sum--;
                if (sum < 0){
                    sum = 1;
                    nowInt = nums[i];
                }
            }
            System.out.println("nowInt: "+nowInt);
        }

        return nowInt;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,2,3,3};
        Solution2 solution2 = new Solution2();
        int result = solution2.majorityElement(nums);
        System.out.println(result);

    }
}
