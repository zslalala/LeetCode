package thrityDaysChanllage.Interview57;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {

        if(target == 1){
            return new int[][]{{1}};
        }

        ArrayList<int[]> arrayList = new ArrayList<>();

        int targetArray[] = new int[target];
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = i+1;
        }

        int pre = 0;
        int last = 1;

        while(last != target){

            int sum = (last-pre)*(targetArray[last-1]+targetArray[pre])/2;
            if(sum < target){
                last++;
            }else if(target == sum){
                int temp[] = new int[last - pre];
                for (int i = pre,j = 0; i < last; i++,j++) {
                    temp[j] = targetArray[i];
                }
                arrayList.add(temp);
                pre++;
                last++;
            }else {
                pre++;
            }
        }

        return arrayList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[][] = solution.findContinuousSequence(1);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
