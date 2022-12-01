package interview.dp;

/**
 * 问题：换钱的最少货币数
 * 题目：给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数 aim 代表要找的钱数，求组成 aim 的最少货币数。
 * 举例：
 * arr=[5,2,3]，aim=20。
 * 4张5元可以组成20元，其他的找钱方案都要使用更多张的货币，所以返回4。
 * arr=[5,2,3]，aim=0。
 * 不用任何货币就可以组成0元，返回0。
 * arr=[3,5]，aim=2。
 * 根本无法组成2元，钱不能找开的情况下默认返回-1。
 * 补充题目：给定数组 arr，arr 中所有的值都为正数。每个值仅代表一张钱的面值，再给定一个整数aim 代表要找的钱数，求组成aim的最少货币数。
 * 举例：arr=[5,2,3]，aim=20。
 * 5元、2元和3元的钱各有1张，所以无法组成20 元，默认返回-1。
 * arr=[5,2,5,3]，aim=10。
 * 5 元的货币有2张，可以组成10 元，且该方案所需张数最少，返回2。
 * arr=[5,2,5,3]，aim=15。
 * 所有的钱加起来才能组成15 元，返回4。
 * arr=[5,2,5,3]，aim=0。
 * 不用任何货币就可以组成0元，返回0
 */
public class Code_03_ChangeMoneyCoins {

    public static int minCoins(int[] array, int aim){
        if(array == null || array.length == 0 || aim < 0)
            return -1;
        int n = array.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        // 对array[0]的倍数进行初始化
        for(int j=1; j <= aim; j++){
            if(j % array[0] == 0){
                dp[0][j] = j / array[0];
            }else{
                dp[0][j] = max;
            }
        }

        int left = 0;
        for(int i=1; i<n; i++){
            for(int j=1; j<=aim; j++){
                left = max;
                if(j - array[i] >= 0 && dp[i][j-array[i]] != max){
                    left = dp[i][j-array[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

}




























