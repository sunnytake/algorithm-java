package interview.dp;

/**
 * 问题：最长公共子串问题
 * 题目：给定两个字符串strl和str2，返回两个字符串的最长公共子串。
 * 举例：strl="1AB2345CD"，str2="12345EF"，返回"2345"
 */
public class Code_07_MaxCommonSubSeq {

    public static String getMaxCommonSubSeq(String str1, String str2){
        if(str1 == null || str2 == null || str1.equals("") || str2.equals(""))
            return "";
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int max = 0;
        int end = 0;
        for(int i=0; i<chars1.length; i++){
            for(int j=0; j<chars2.length; j++){
                if(dp[i][j] > max){
                   max = dp[i][j];
                   end = i;
                }
            }
        }
        return str1.substring(end - max + 1, end+1);
    }

    public static int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        for(int i=0; i<str1.length; i++){
            dp[i][0] = str1[i] == str2[0] ? 1 : 0;
        }
        for(int j=1; j<str2.length; j++){
            dp[0][j] = str1[0] == str2[j] ? 1 : 0;
        }
        for(int i=1; i<str1.length; i++){
            for(int j=1; j<str2.length; j++){
                if(str1[i] == str2[j])
                    dp[i][j] = dp[i-1][j-1] +1;
            }
        }
        return dp;
    }

}
