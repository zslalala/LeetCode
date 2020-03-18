package thrityDaysChanllage.Interview1001;

public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {

        int pnow = m + n -1;
        int pa = m - 1;
        int pb = n - 1;

        while(pa >= 0 && pb >= 0){
            if(A[pa] > B[pb]){
                A[pnow--] = A[pa--];
            }else{
                A[pnow--] = B[pb--];
            }
        }
        while (pa >= 0){
            A[pnow--] = A[pa--];
        }
        while (pb >= 0){
            A[pnow--] = B[pb--];
        }

    }

    public static void main(String[] args) {

        int m = 3,n = 3;
        int A[] = {1,2,3,0,0,0};
        int B[] = {2,5,6};

        System.out.println("反转前");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();

        Solution solution = new Solution();
        solution.merge(A,m,B,n);

        System.out.println("反转后");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }

}
