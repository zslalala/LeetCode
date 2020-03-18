package LeetCode64;

/***
 *注意边界条件的书写标准
 * 状态转移方程的当前的cost,不要写成DP[i][j] = Math.min(DP[i-1][j]+cost,DP[i][j-1]+cost)
 * 应写为DP[i][j] = Math.min(DP[i-1][j],DP[i][j-1])+cost
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dparr = new int[row][col];
        dparr[0][0] = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 && j == 0)
                    dparr[i][j] = grid[i][j];
                else if(i == 0)
                    dparr[i][j] = dparr[i][j-1]+grid[i][j];
                else if(j == 0)
                    dparr[i][j] = dparr[i-1][j]+grid[i][j];
                else{
                    dparr[i][j] = Math.min(dparr[i-1][j],dparr[i][j-1])+grid[i][j];
                }
            }
        }
        return dparr[row-1][col-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = solution.minPathSum(grid);
        System.out.println(result);
    }
}
