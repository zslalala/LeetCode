package thrityDaysChanllage.LeetCode169.LeetCode229;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> finalList = new ArrayList<>();

        int num1 = Integer.MAX_VALUE,num2 = Integer.MAX_VALUE;
        int value1 = 0,value2 = 0;
        boolean flag1 = false,flag2 = false;

        for (int i = 0; i < nums.length; i++) {

            if (flag1 && nums[i] == num1){
                value1++;
                continue;
            }

            if (flag2 && nums[i] == num2){
                value2++;
                continue;
            }

            if (!flag1){
                num1 = nums[i];
                value1 = 1;
                flag1 = true;
                continue;
            }

            if (!flag2){
                num2 = nums[i];
                value2 = 1;
                flag2 = true;
                continue;
            }

            value1--;
            value2--;

            if (value1 <= 0){
                flag1 = false;
            }

            if (value2 <= 0){
                flag2 = false;
            }
        }

        boolean result1 = GetFlag(num1,nums);
        boolean result2 = GetFlag(num2,nums);

        if (result1)
            finalList.add(num1);
        if (result2 && num2!=num1)
            finalList.add(num2);

        return finalList;
    }

    private boolean GetFlag(int num1, int[] nums) {

        int threshold = nums.length / 3;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num1 == nums[i]){
                times++;
                if(times > threshold)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = new int[]{0,-1,2,-1};
        List<Integer> integerList = solution.majorityElement(nums);
        System.out.println(integerList);

    }
}
