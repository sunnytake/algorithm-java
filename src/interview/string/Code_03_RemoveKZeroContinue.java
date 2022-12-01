package interview.string;


/**
 * 问题：去掉字符串中连续出现k个0的子串
 * 题目：给定一个字符串str和一个整数k，如果str中正好有连续的k个'0'字符出现时，把k个连续的'0'字符去除，返回处理后的字符串。
 */
public class Code_03_RemoveKZeroContinue {

    public static String removeZeros(String str, int k){
        if(str == null || k < 1)
            return str;
        char[] chars = str.toCharArray();
        int count = 0;
        int start = -1;
        int length = chars.length;
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            }else{
                if(count == k){
                    while(count-- != 0)
                        chars[start++] = 0;
                    length -= k;
                }
                count = 0;
                start = -1;
            }
        }
        if(count == k){
            while(count-- != 0)
                chars[start++] = 0;
            length -= k;
        }
        return String.valueOf(chars, 0, length);
    }

    public static void main(String[] args) {
        String str1 = "A00B";
        System.out.println(removeZeros(str1, 2));
        String str2 = "A0000B000";
        System.out.println(removeZeros(str2, 3));

    }

}
