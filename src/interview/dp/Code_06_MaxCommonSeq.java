package interview.dp;

/**
 * 问题：最长公共子序列问题
 * 题目：给定两个字符串 strl 和 str2，返两个字符串的最长公共子序列。
 * 举例：
 * strl="1A2C3D4B56"，str2="B1D23CA45B6A"
 * ”123456"或者"12C4B6"都是最长公共子序列，返回哪一个都行
 */
public class Code_06_MaxCommonSeq {

    public static String getMaxCommonSeq(String str1, String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int length1 = chars1.length - 1;
        int length2 = chars2.length - 1;
        char[] res = new char[dp[length1][length2]];
        int index = res.length - 1;
        while(index > 0){
            if(length2 > 0 && dp[length1][length2] == dp[length1][length2-1])
                length2--;
            else if(length1 > 0 && dp[length1][length2] == dp[length1-1][length2])
                length1--;
            else{
                res[index--] = chars1[length1];
                length1--;
                length2--;
            }
        }
        return String.valueOf(res);
    }

    public static int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for(int i=1; i<str1.length; i++)
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
        for(int j=1; j<str2.length; j++)
            dp[0][j] = Math.max(dp[0][j-1], str1[0] == str2[j] ? 1 : 0);
        for(int i=1; i<str1.length; i++){
            for(int j=1; j<str2.length; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(str1[i] == str2[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
            }
        }
        return dp;
    }
}
