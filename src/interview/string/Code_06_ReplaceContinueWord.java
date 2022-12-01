package interview.string;

/**
 * 问题：替换字符串中连续出现的指定字符串
 * 题目：
 * 给定三个字符串str、from和to，把str中所有from的子串全部替换成to字符串，
 * 对连续出现from的部分要求只替换成一个to字符串，返回最终的结果字符串
 * 举例：
 * str="123abc"，from="abc"，to="4567”，返回"1234567"
 * str="123”，from="abc"，to="456"，返回"123"
 * str="123abcabc"，from="abc"，to="X"，返回"123X"
 */
public class Code_06_ReplaceContinueWord {
    public static String replace(String str, String from, String to){
        if(str == null || from == null || str.equals("") || from.equals(""))
            return str;
        char[] chars = str.toCharArray();
        char[] fromChars = from.toCharArray();
        String res = "";
        int sameFromIndex = 0;
        int sameCount = 0;
        boolean preReplaced = false;
        for(int i=0; i<chars.length; i++){
            if(sameFromIndex < fromChars.length && chars[i] == fromChars[sameFromIndex]){
                sameCount++;
                sameFromIndex++;
            }else{
                for(int j=i-sameCount; j<=i; j++)
                    res += chars[j];
                preReplaced = false;
            }
            if(sameCount == from.length() && !preReplaced){
                res += to;
                sameCount = 0;
                sameFromIndex = 0;
                preReplaced = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "123abc";
        String from1 = "abc";
        String to1 = "4567";
        System.out.println(replace(str1, from1, to1));//1234567
        String str2 = "123";
        String from2 = "abc";
        String to2 = "456";
        System.out.println(replace(str2, from2, to2));//123
        String str3 = "123abcabc";
        String from3 = "abc";
        String to3 = "X";
        System.out.println(replace(str3, from3, to3));//123X
    }
}
