package interview.dp;

/**
 * 问题：最小编辑代价
 * 题目：给定两个字符串 strl 和 str2，再给定三个整数 c、dc和rc，分别代表插入、删除和替换一个字符的代价，返回将str1 编辑成str2的最小代价。
 * 举例：
 * strl="abc"，str2="adc"，ic=5，dc=3，rc=2。
 * 从"abc"编辑成"adc"，把b替换成d是代价最小的，所以返回2。
 * strl="abc"，str2="adc"，ic-5，dc=3，rc=100。
 * 从"abc"编辑成"adc"，先删除b，然后插入d是代价最小的，所以返回8
 * strl="abc"，str2="abc"，ic=5，dc=3，rc=2。
 * 不用编辑了，本来就是一样的字符串，所以返回0。
 */
public class Code_08_MinModifyCost {
    // dp[i][j]标识把str1[0...i-1]编辑为str2[0...j-1]的最小代价
    public static int getMinModifyCost(String str1, String str2, int ic, int dc, int rc){
        if(str1 == null || str2 == null)
            return 0;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int row = chars1.length + 1;
        int col = chars2.length + 1;
        int[][] dp = new int[row][col];
        for(int i=1; i<row; i++)
            dp[i][0] = dc * i;
        for(int j=1; j<col; j++)
            dp[0][j] = ic * j;
        for(int i = 1; i<row; i++) {
            for (int j = 1; j < col; j++){
                if(chars1[i-1] == chars2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1] + rc;
                dp[i][j] = Math.min(dp[j][j], dp[i][j-1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dc);
            }
        }
        return dp[row-1][col-1];
    }

}
