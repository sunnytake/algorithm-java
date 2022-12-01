package interview.dp;

/**
 * 问题：字符串的交错组成
 * 题目：
 * 给定三个字符串 strl、str2和aim,如果aim 包含且仅包含来自 strl和 str2 的所有字符，
 * 而且在 aim 中属于 str1 的字符之间保持原来在 strl 中的顺序，属于 str2 的字符之间保持原来在str2 中的顺序，
 * 那么称aim 是 strl和 str2 的交错组成。
 * 实现一个函数，判断aim 是否是str1和str2交错组成。
 * 举例：
 * strl="AB"，str2="12"。那么"AB12"、"A1B2"、"A12B"、"1A2B"和"1AB2"等都是 strl和str2的交错组成
 */
public class Code_09_StringCross {

    public static boolean isCross(String str1, String str2, String aim){
        if(str1 == null || str2 == null || aim == null)
            return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] aimChars = aim.toCharArray();
        if(aimChars.length != chars1.length + chars2.length)
            return false;
        boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
        dp[0][0] = true;
        for(int i=1; i<chars1.length; i++){
            if(chars1[i-1] != aimChars[i-1])
                break;
            dp[i][0] = true;
        }
        for(int j=1; j<chars2.length; j++){
            if(chars2[j-1] != aimChars[j-1])
                break;
            dp[0][j] = true;
        }
        for(int i=1; i<chars1.length; i++){
            for(int j=1; j<chars2.length; j++){
                if((chars1[i-1] == aimChars[i+j-1] && dp[i-1][j]) || (chars2[j-1] == aimChars[i+j-1] && dp[i][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

}
