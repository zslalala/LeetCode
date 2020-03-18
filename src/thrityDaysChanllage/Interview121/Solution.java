package thrityDaysChanllage.Interview121;

public class Solution {

    public int maxProfit(int[] prices,int fee) {

        int length = prices.length;

        if (length == 0)
            return 0;

        int[][] dprices = new int[length][2];
        for (int i = 0; i < length; i++) {

            if (i == 0){
                dprices[0][0] = 0;
                dprices[0][1] = -prices[0];
            } else {
                dprices[i][0] = Math.max(dprices[i-1][0],dprices[i-1][1]+prices[i]-fee);
                dprices[i][1] = Math.max(dprices[i-1][1],dprices[i-1][0]-prices[i]);
            }
        }

        return dprices[length-1][0];

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int fee = 2;
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int profit = solution.maxProfit(prices,fee);
        System.out.println("profit = "+profit);
    }

}
