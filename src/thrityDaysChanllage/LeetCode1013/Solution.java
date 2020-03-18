package thrityDaysChanllage.LeetCode1013;

public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {

        if (A.length < 3)
            return false;

        boolean frontFlag = false;
        boolean backFlag = false;

        int frontPoint = 0;
        int backPoint = A.length - 1;

        int frontSum = 0;
        int backSum = 0;
        int targetSum = 0;

        for (int i = 0; i < A.length; i++) {
            targetSum += A[i];
        }

        if(targetSum % 3 != 0)
            return false;
        else
            targetSum = targetSum / 3;

        while (frontPoint + 1 < backPoint){

            if (!frontFlag){
                frontSum += A[frontPoint];
                if(frontSum == targetSum){
                    frontFlag = true;
                }else {
                    frontPoint++;
                }
            }

            if (!backFlag){
                backSum += A[backPoint];
                if (backSum == targetSum){
                    backFlag = true;
                }else {
                    backPoint--;
                }
            }

            if (frontFlag && backFlag){
                System.out.println(frontPoint);
                System.out.println(backPoint);
                return true;
            }
        }
        System.out.println(frontPoint);
        System.out.println(backPoint);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{3,3,6,5,-2,2,5,1,-9,4};
        boolean isOK = solution.canThreePartsEqualSum(A);
        System.out.println(isOK);
    }

}
