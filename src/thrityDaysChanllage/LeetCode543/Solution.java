package thrityDaysChanllage.LeetCode543;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class Solution {

    int maxvalue = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root != null){
            findDeep(root);
            return maxvalue;
        }

        return 0;
    }

    public int findDeep(TreeNode root){

        if(root != null){

            int left = findDeep(root.left);
            int right = findDeep(root.right);
            int sum = left + right;
            if(sum > maxvalue)
                maxvalue = sum;
            return Math.max(right,left)+1;
        }
        return 0;


    }

    public static void main(String[] args) {

        TreeNode tNode = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        tNode.left = t1;
        tNode.right = t2;
        t1.left = t3;
        t1.right = t4;
        t4.right = t5;
        Solution solution = new Solution();
        int result = solution.diameterOfBinaryTree(tNode);
        System.out.println(result);
    }


}
