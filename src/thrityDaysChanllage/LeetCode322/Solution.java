package thrityDaysChanllage.LeetCode322;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {


    HashMap<Integer,Integer> integerHashMap = new HashMap<>();

    public int dp(int[] coins,int amount){

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if(integerHashMap.containsKey(amount))
            return integerHashMap.get(amount);

        boolean flag = false;
        int res = 10000;
        int minvalue = 10000;

        for (int i = 0; i < coins.length; i++) {

            res = dp(coins,amount-coins[i]);

            if(res != -1 && res < minvalue){
                flag = true;
                minvalue = res;
            }
        }

        if(flag == false){
            integerHashMap.put(amount,-1);
            return -1;
        }else{
            integerHashMap.put(amount,minvalue+1);
            return minvalue+1;
        }
    }


    public int coinChange(int[] coins, int amount) {

        return dp(coins,amount);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1,2,5};
        int times = solution.coinChange(coins,11);
        System.out.println(times);
    }
}
