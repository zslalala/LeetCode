package thrityDaysChanllage.Interview121;

import thrityDaysChanllage.LeetCode322.Solution;

public class Solution2 {

    public int maxProfit(int[] prices) {

        int length = prices.length;

        if (length == 0){
            return 0;
        }

        int[][][] dprices = new int[length][3][2];

        //当i=0时，即第一天，要求所有的dprices[0][k][0] = 0,dprices[0][k][1] = -dprices[0]
        for (int i = 0; i < 3; i++) {
            dprices[0][i][0] = 0;
            dprices[0][i][1] = -prices[0];
        }

        //注意：买的时候+1j，卖的时候不加
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 3; j++) {

                if (j == 0){
                    dprices[i][j][0] = dprices[i-1][j][0];
                }else {
                    dprices[i][j][0] = Math.max(dprices[i-1][j][0],dprices[i-1][j-1][1] + prices[i]);
                }
                dprices[i][j][1] = Math.max(dprices[i-1][j][1],dprices[i-1][j][0] - prices[i]);
            }
        }

        return Math.max(dprices[length-1][0][0],Math.max(dprices[length-1][1][0],dprices[length-1][2][0]));
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(solution2.maxProfit(prices));
    }
}
