package thrityDaysChanllage.LeetCode836;

public class Solution {

    //首先考虑线段(x1,x2)和线段(y1,y2)有重合的要求是什么，
    //可以想到两个线段相交时形成的线段一定是两个线段的左端点取最大A，右端点取最小B，如果A<B,那么重合
    //数学公式的应该算是Max(x1,y1) < Min(x2,y2)
    //现在考虑二维的话不妨可以认为是在x轴上的投影和在y轴上的投影分别满足两个线段重合的要求
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return ((Math.max(rec1[0],rec2[0]) < Math.min(rec1[2],rec2[2])) &&
                (Math.max(rec1[1],rec2[1]) < Math.min(rec1[3],rec2[3])));

    }

    public static void main(String[] args) {

        int[] rec1 = new int[]{0,0,2,2};
        int[] rec2 = new int[]{1,1,3,3};

        Solution solution = new Solution();
        boolean flag = solution.isRectangleOverlap(rec1,rec2);
        System.out.println(flag);
    }

}
