package interview.dp;

/**
 * 问题：数字字符串转换为字母组合的种数
 * 题目：
 * 给定一个字符串 str，str全部由数字字符组成，如果 str中某一个或某相邻两个字符组成的子串值在 1~26 之间，则这个子串可以转换为一个字母。
 * 规定"1"转换为"A”，"2"转换为"B"，"3"转换为"C”..."26"转换为"Z”。
 * 写一个函数，求 str 有多少种不同的转换结果，并返回种数。
 */
public class Code_11_NumStringToCharSeq {

    // 时间复杂度O(2^N)
    public static int getNumRecur(String str){
        if(str == null || str.equals(""))
            return 0;
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    public static int process(char[] chars, int i){
        if(i == chars.length)
            return 1;
        if(chars[i] == '0'){
            return 0;
        }
        int res = process(chars, i+1);
        if(i+1 < chars.length && (chars[i] - '0') * 10 + chars[i+1] - '0' < 27)
            res += process(chars, i+2);
        return res;
    }

    public static int getNum(String str){
        if(str == null || str.equals(""))
            return 0;
        char[] chars = str.toCharArray();
        int cur = chars[chars.length-1] == '0' ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for(int i=chars.length-2; i>=0; i--){
            if(chars[i] == '0'){
                next = cur;
                cur = 0;
            }else{
                tmp = cur;
                if((chars[i] - '0') * 10 + chars[i+1] - '0' < 27)
                    cur += next;
                next = tmp;
            }
        }
        return cur;
    }

}
