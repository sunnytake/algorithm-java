package interview.string;

/**
 * 问题：字符串中数字子串的求和
 * 题目：给定一个字符串 str，求其中全部数字串所代表的数字之和。
 * 1.忽略小数点字符，例如"A1.3"，其中包含两个数字1和3。
 * 2.如果紧贴数字子串的左侧出现字符"-"，当连续出现的数量为奇数时，则数字视为负连续出现的数量为偶数时，则数字视为正。例如，"A-1BC--12"，其中包含数字为-1和12
 * 举例：
 * str="A1CD2E33"，返回36。
 * str="A-1B--2C--D6E"，返回7
 */
public class Code_02_NumSubStringSum {
    public static int numSum(String str){
        if(str == null)
            return 0;
        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        int cur = 0;
        boolean posive = true;
        for(int i=0; i<chars.length; i++){
            cur = chars[i] - '0';
            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(chars[i] == '-'){
                    if(i-1 > -1 && chars[i-1] == '-')
                        posive = !posive;
                    else
                        posive = false;
                }else{
                    posive = true;
                }
            }else{
                num = num * 10 + (posive ? cur : -cur);
            }
        }
        return res;
    }
}
