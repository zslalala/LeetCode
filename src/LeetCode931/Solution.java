package LeetCode931;

public class Solution {

    public int minFallingPathSum(int[][] A) {

        int[][] dparr = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            dparr[0][i] = 0;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                //观察A[i-1][j-1]在不在
                int temp1 = 99999;
                int temp2 = 99999;
                int temp3 = 99999;
                if (j-1 < 0)
                    temp1 = 99999;
                else
                    temp1 = dparr[i-1][j-1] + A[i-1][j-1];

                temp2 = dparr[i-1][j] + A[i-1][j];

                if (j+1>=A.length)
                    temp3 = 99999;
                else
                    temp3 = dparr[i-1][j+1] + A[i-1][j+1];
                dparr[i][j] = Math.min(Math.min(temp1,temp2),temp3);
            }
        }

        int minresult = 99999;
        for (int i = 0; i < A.length; i++) {
            int temp = dparr[A.length-1][i] + A[A.length-1][i];
            if (temp < minresult)
                minresult = temp;
        }
        return minresult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] A = {{1,2,3,4},{4,5,6,7},{6,7,8,9},{7,8,9,10}};
        int result = solution.minFallingPathSum(A);
        System.out.println(result);
    }
}
