package interview.string;

/**
 * 问题：将整数字符串转成整数值
 * 题目：给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数的范围，返回str所代表的整数值，否则返回0。
 * 举例：
 * str="123"”，返回123
 * str=”023”，因为”023"不符合日常的书写习惯，所以返回0
 * str="A13"，返回0。str-"0"，返回0。
 * str="2147483647"，返回2147483647
 * str="2147483648”，因为溢出了，所以返回0
 * str="-123"，返回-123。
 */
public class Code_05_StringToInt {
    public static int convert(String str){
        if(str == null || str.equals(""))
            return 0;
        char[] chars = str.toCharArray();
        if(!isValid(chars))
            return 0;
        boolean positive = chars[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for(int i=positive ? 0 : 1; i<chars.length; i++){
            cur = '0' - chars[i];
            if((res < minq) || (res == minq && cur < minr))
                return 0;
            res = res*10 + cur;
        }
        if(positive && res == Integer.MIN_VALUE)
            return 0;
        return positive ? -res : res;
    }

    public static boolean isValid(char[] chars){
        if(chars[0] != '-' && (chars[0] < '0' || chars[0] > '9'))
            return false;
        if(chars[0] == '-' && (chars.length == 1 || chars[1] == 0))
            return false;
        if(chars[0] == '0' && chars.length > 1)
            return false;
        for(int i=1; i<chars.length; i++){
            if(chars[i] < '0' || chars[i] > '9')
                return false;
        }
        return true;
    }
}
