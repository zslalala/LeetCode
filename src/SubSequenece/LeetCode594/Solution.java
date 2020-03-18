package SubSequenece.LeetCode594;

import java.util.HashMap;

public class Solution {

    public int findLHS(int[] nums) {

        HashMap<Integer,Integer> integerMap = new HashMap<>();
        int max_length = 0;

        for(int i=0;i<nums.length;++i){
            if(!integerMap.containsKey(nums[i])){
                integerMap.put(nums[i],1);
            }else{
                int value = integerMap.get(nums[i]);
                value++;
                integerMap.put(nums[i],value);
            }
            int now_value = integerMap.get(nums[i]);
            max_length = Math.max(max_length,now_value);

            if(integerMap.containsKey(nums[i]-1)){
                int tempvalue = integerMap.get(nums[i]-1);
                max_length = Math.max(max_length,now_value+tempvalue);
            }

            if(integerMap.containsKey(nums[i]+1)){
                int tempvalue = integerMap.get(nums[i]+1);
                max_length = Math.max(max_length,now_value+tempvalue);
            }

        }
        return max_length;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        Solution solution = new Solution();
        int result = solution.findLHS(nums);
        System.out.println(result);
    }
}
