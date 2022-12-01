package interview.string;

/**
 * 问题：字符串的统计字符串
 * 题目：给定一个字符串str，返回str的统计字符串。例如，"aaabbadddffc"的统计字符串为"a_3_b_2_a_1_d_3_f_2_c_1"
 * 补充题目：
 * 给定一个字符串的统计字符串cstr，再给定一个整数index，返回cstr所代表的原始字符串上的第index个字符。
 * 例如，"a_1_b_100"所代表的原始字符串上第0个字符是'a'，第50个字符是'b'。
 */
public class Code_07_String2CountString {

    public static char getCharAt(String countStr, int index){
        if(countStr == null || countStr.equals(""))
            return 0;
        char[] chars = countStr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for(int i=0; i != chars.length; i++){
            if(chars[i] == '_'){
                stage = !stage;
            }else if(stage){
                sum += num;
                if(sum > index)
                    return cur;
                num = 0;
                cur = chars[i];
            }else{
                num = num * 10 + chars[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

    public static String getCountString(String str){
        if(str == null || str.equals(""))
            return "";
        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for(int i=1; i<chars.length; i++){
            if(chars[i] != chars[i-1]){
                res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
                num = 1;
            }else{
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    public static String concat(String str1, String str2, String str3){
        return str1 + "_" + str2 + (str3.equals("") ? str3 : "_" + str3);
    }
}
