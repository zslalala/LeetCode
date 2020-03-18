package LeetCode645;

//Java 5.06%in time and 5.07% in space
public class Solution1 {

    //注意这里的i,j是和大的String对应的，而不是和这里的字串对应的
    public boolean isPdmic(String str,int[][] dparr,int i,int j){

        if(dparr[i][j] != -1){
            if(dparr[i][j] == 1)
                return true;
            else
                return false;
        }
        else{
            if(str.length() == 1){
                dparr[i][j] = 1;
                return true;
            }
            else if(str.length() == 2){
                if(str.charAt(0) == str.charAt(1)){
                    dparr[i][j] = 1;
                    return true;
                }
                else{
                    dparr[i][j] = 0;
                    return false;
                }
            }
            else{
                char firstc = str.charAt(0);
                char endc = str.charAt(str.length()-1);
                String newstr = str.substring(1,str.length()-1);
                if((firstc == endc)&&isPdmic(newstr,dparr,i+1,j-1)){
                    dparr[i][j] = 1;
                    return true;
                }
                else{
                    dparr[i][j] = 0;
                    return false;
                }
            }
        }

    }

    public int countSubstrings(String s) {

        int count = 0;
        int strlen = s.length();
        int[][] dparr = new int[strlen][strlen];

        //初始化DP数组
        for (int i = 0; i < strlen; i++) {
            for (int j = 0; j < strlen; j++) {
                dparr[i][j] = -1;
            }
        }
        //生成所有连续字串
        for (int i = 0; i < strlen; i++) {
            String newstr = "";
            for (int j = i; j < strlen; j++) {
                newstr += s.charAt(j);
//                newstr="aba";
//                System.out.println(newstr);
                if(isPdmic(newstr,dparr,i,j)){
//                    System.out.println(newstr);
//                    System.out.println(isPdmic(newstr,dparr,i,j));
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "aaa";
        int result = solution.countSubstrings(s);
        System.out.println(result);
    }

}
