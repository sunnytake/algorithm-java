package interview.dp;

/**
 * 问题：换钱的方法数
 * 给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张,再给定一个整数 aim 代表要找的钱数,求换钱有多少种方法。
 * arr=[5,10,25,1]，aim=0。组成0元的方法有1种，就是所有面值的货币都不用。所以返回 1。
 * arr=[5,10.25,1]，aim=15组成 15 元的方法有 6 种，分别为 3 张5 元、1张 10 元+1 张5 元1张10元+5 张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所以返回6。arr=[3,5]，aim=2。
 * 任何方法都无法组成2元。所以返回0
 */
public class Code_04_ChangeMoneyMethods {

    // 暴力递归：最差情况时间复杂度为O(aim^N)
    public int coins(int[] array, int aim){
        if(array == null || array.length == 0 || aim < 0)
            return 0;
        return process(array, 0, aim);
    }

    public int process(int[] array, int index, int aim){
        int res = 0;
        if(index == array.length)
            res = aim == 0 ? 1 : 0;
        else{
            for(int i=0; array[index]*i <= aim; i++){
                res += process(array, index+1, aim-array[index]*i);
            }
        }
        return res;
    }

    public int coninsDp(int[] array, int aim){
        if(array == null || array.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[array.length][aim+1];
        for(int i=0; i<array.length; i++)
            dp[i][0] = 1;
        for(int j=1; array[0]*j <= aim; j++)
            dp[0][array[0]*j] = 1;
        for(int i=1; i<array.length; i++)
            for(int j=1; j<=aim; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - array[i] >= 0 ? dp[i][j-array[i]] : 0;
            }
        return dp[array.length-1][aim];
    }

}
