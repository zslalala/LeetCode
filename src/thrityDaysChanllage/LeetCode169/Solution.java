package thrityDaysChanllage.LeetCode169;

import java.util.HashMap;

public class Solution {

    public int majorityElement(int[] nums) {

        if (nums.length == 1 || nums.length == 2)
            return nums[0];

        HashMap<Integer,Integer> integerHashMap = new HashMap<>();

        int threshold = nums.length / 2 + 1;

        for (int i = 0; i < nums.length; i++) {

            if (integerHashMap.containsKey(nums[i])){
                int value = integerHashMap.get(nums[i]);
                value++;
                if (value == threshold)
                    return nums[i];
                integerHashMap.put(nums[i],value);
            }else {
                integerHashMap.put(nums[i],1);
            }

        }
        return 0;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,3};
        Solution solution = new Solution();
        int result = solution.majorityElement(nums);
        System.out.println(result);

    }


}
