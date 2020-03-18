package thrityDaysChanllage.LeetCode695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private boolean[][] flagArray;

    public int deepSearch(int[][] grid,int i,int j){

        int nowArea = 0;
        int gridWidth = grid.length;
        int gridLength = grid[0].length;

        Queue<int[]> intQueue = new LinkedList<>();
        intQueue.offer(new int[]{i,j});
        flagArray[i][j] = true;
        nowArea++;

        while (!intQueue.isEmpty()){

            //从队列中取出元素
            int[] tempArray = intQueue.poll();
            int tempi = tempArray[0];
            int tempj = tempArray[1];

            if(tempi-1>=0 && grid[tempi-1][tempj] == 1 && !flagArray[tempi-1][tempj]){
                intQueue.offer(new int[]{tempi-1,tempj});
                flagArray[tempi-1][tempj] = true;
                nowArea++;
            }

            if (tempi+1<=(gridWidth-1) && grid[tempi+1][tempj] == 1 && !flagArray[tempi+1][tempj]){
                intQueue.offer(new int[]{tempi+1,tempj});
                flagArray[tempi+1][tempj] = true;
                nowArea++;
            }

            if (tempj-1>=0 && grid[tempi][tempj-1] == 1 && !flagArray[tempi][tempj-1]){
                intQueue.offer(new int[]{tempi,tempj-1});
                flagArray[tempi][tempj-1] = true;
                nowArea++;
            }

            if (tempj+1<=(gridLength-1) && grid[tempi][tempj+1] == 1 && !flagArray[tempi][tempj+1]){
                intQueue.offer(new int[]{tempi,tempj+1});
                flagArray[tempi][tempj+1] = true;
                nowArea++;
            }
        }
        return nowArea;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int width = grid.length;
        int length = grid[0].length;
        flagArray = new boolean[width][length];
        int maxArea = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (!flagArray[i][j] && grid[i][j] == 1){
                    int area = deepSearch(grid,i,j);
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {

//        int[][] grid = new int[][]{
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//        };
        int[][] grid= new int[][]{
                {0,0,0,0,0,0,0,0}
        };

        Solution solution = new Solution();
        int maxArea = solution.maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

}
