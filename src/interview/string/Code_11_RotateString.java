package interview.string;

/**
 * 问题：翻转字符串
 * 题目：给定一个字符类型的数组 chas,请在单词间做逆序调整。只要做到单词顺序逆序即可，对空格的位置没有特别要求。
 * 举例：
 * 如果把 chas看作字符串为"dog loves pig”，调整成"pig Loves dog"
 * 如果把chas 看作字符串为"I'm a student."，调整成"student. a I'm”
 * 补充题目：
 * 给定一个字符类型的数组 chas 和一个整数 size，请把大小为size的左半区整体移到右半区，右半区整体移到左边。
 * 举例：
 * 如果把chas看作字符串为”ABCDE"，size=3，调整成"DEABC”
 */
public class Code_11_RotateString {
    // 补充问题：先把chars[0...size-1]部分逆序，再把chars[size...n-1]部分逆序，最后整体逆序
    public static void rotate(char[] chars, int size){
        if(chars == null || size <= 0 || size >= chars.length)
            return;
        reverse(chars, 0, size-1);
        reverse(chars, size, chars.length-1);
        reverse(chars, 0, chars.length-1);
    }

    // 原问题：先把整体逆序，再把每个单词逆序即可
    public static void rotateWord(char[] chars){
        if(chars == null || chars.length == 0)
            return;
        reverse(chars, 0, chars.length - 1);
        int left = -1;
        int right = -1;
        for(int i=0; i<chars.length; i++){
            if(chars[i] != ' '){
                if(i==0 || chars[i-1] == ' ')
                    left = i;
                if(i == chars.length-1 || chars[i+1] == ' ')
                    right = i;
            }
            if(left != -1 && right != -1){
                reverse(chars, left, right);
                left = -1;
                right = -1;
            }
        }
    }

    public static void reverse(char[] chars, int start, int end){
        char temp = 0;
        while(start < end){
            temp = chars[start];
            chars[start++] = chars[end--];
        }
    }
}
