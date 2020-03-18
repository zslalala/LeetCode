package thrityDaysChanllage.LeetCode994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int []> queue = new LinkedList<>();
        int times = 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
                if(grid[i][j] == 1)
                    count++;
            }
        }

        while (count>0 && !queue.isEmpty()){

            times++;
            int num = queue.size();

            for (int i = 0; i < num; i++) {

                int m = queue.peek()[0];
                int n = queue.peek()[1];
                queue.poll();

                if(m > 0 && grid[m-1][n] == 1){
                    grid[m-1][n] = 2;
                    queue.offer(new int[]{m-1,n});
                    count--;
                }
                if(m < grid.length - 1 && grid[m+1][n] == 1){
                    grid[m+1][n] = 2;
                    queue.offer(new int[]{m+1,n});
                    count--;
                }
                if(n > 0 && grid[m][n-1] == 1){
                    grid[m][n-1] = 2;
                    queue.offer(new int[]{m,n-1});
                    count--;
                }
                if(n < grid[0].length - 1 && grid[m][n+1] == 1){
                    grid[m][n+1] = 2;
                    queue.offer(new int[]{m,n+1});
                    count--;
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    flag = false;
                    break;
                }
            }
        }

        if (flag == true){
            return times;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int grid[][] = {{2,2,2,1,1}};

        int times = solution.orangesRotting(grid);
        System.out.println("times = "+times);
        System.out.println("矩阵为:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(grid[i][j]);
            }
        }
    }

}
