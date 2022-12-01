package interview.string;

/**
 * 问题：字符串的调整与替换
 * 题目：
 * 给定一个字符类型的数组chas[]，chas右半区全是空字符，左半区不含有空字符。
 * 现在想将左半区中所有的空格字符替换成”%20"，假设 chas 右半区足够大，可以满足替换所需要的空间，请完成替换函数。
 * 举例：
 * 如果把 chas的左半区看作字符串，为"a b c"，假设 chas 的右半区足够大。替换后chas 的左半区为"a%20b%20%20c"
 * 要求：
 * 替换函数的时间复杂度为 O(N)，额外空间复杂度为 O(1)
 * 补充题目：
 * 给定一个字符类型的数组chas[]，其中只含有数字字符和“*”字符。现在想把所有的“*”字符挪到chas的左边，数字字符挪到chas的右边。请完成调整函数
 */
public class Code_10_StrModifyAndReplace {

    public static void replace(char[] chars){
        if(chars == null || chars.length == 0)
            return;
        int num = 0;
        int len = 0;
        for(len = 0; len<chars.length && chars[len] != 0; len++){
            if(chars[len] == ' ')
                num++;
        }
        int j = len + num * 2 - 1;
        for(int i=len-1; i>-1; i--){
            if(chars[i] != ' '){
                chars[j--] = chars[i];
            }else{
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
        }
    }

    public static void modify(char[] chars){
        if(chars == null || chars.length == 0)
            return;
        int j = chars.length - 1;
        for(int i=chars.length - 1; i>-1; i--){
            if(chars[i] != '*')
                chars[j--] = chars[i];
        }
        while(j>-1){
            chars[j--] = '*';
        }
    }

}
