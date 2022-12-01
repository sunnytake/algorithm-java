package interview.string;

/**
 * 问题：添加最少字符使字符串整体都是回文字符串
 * 题目：
 * 给定一个字符串str，如果可以在str的任意位置添加字符，请返回在添加字符最少的情况下，让 str整体都是回文字符串的一种结果。
 * 进阶题目：
 * 给定一个字符串str，再给定str的最长回文子序列字符串strlps，请返回在添加字符最少的情况下，
 * 让 str 整体都是回文字符串的一种结果。进阶问题比原问题多了一个参数，请做到时间复杂度比原问题的实现低。
 */
public class Code_13_AddMinCharToPalindrome {

    // dp[i][j]代表子串str[i..j]最少添加几个字符可以使得str[i..j]整体都是回文串
    public int[][] getDp(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int j=1; j<str.length; j++){
            dp[j-1][j] = str[j-1] == str[j] ? 0 : 1;
            for(int i=j-2; i>-1; i--){
                if(str[i] == str[j]){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) +1;
                }
            }
        }
        return dp;
    }


}
