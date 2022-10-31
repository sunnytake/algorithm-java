package basic_class.class06;

/**
 * 给定一个数组arr（都为正数）和一个整数aim
 * 如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
 */
public class Code_08_Money_Problem {

    // 暴力递归
    public static boolean moneyProblem(int[] array, int aim, int i, int sum){
        if(array == null || array.length == 0)
            return false;
        if(sum == aim)
            return true;
        if(i == array.length)
            return false;
        return moneyProblem(array, aim, i+1, sum) || moneyProblem(array, aim, i+1, sum + array[i]);
    }

    // 动态规划
    public static boolean moneyProblem(int[] array, int aim){
        if(array == null || array.length == 0)
            return false;
        boolean[][] dp = new boolean[array.length+1][aim+1];
        for(int i=0; i<dp.length; i++){
            dp[i][aim] = true;
        }
        for(int i=array.length - 1; i>=0; i--){
            for(int j=aim-1; j>=0; j--){
                dp[i][j] = dp[i+1][j];
                if(j + array[i] <= aim)
                    dp[i][j] = dp[i][j] || dp[i+1][j + array[i]];
            }
        }
        return dp[0][0];
    }
}
