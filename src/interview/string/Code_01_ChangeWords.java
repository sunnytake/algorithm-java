package interview.string;

/**
 * 问题：判断两个字符串是否互为变形词
 * 题目：给定两个字符串strl 和str2，如果str 和str2中出现的字符种类一样且每种字符出现的次数也一样，那么strl与str2互为变形词。请实现函数判断两个字符串是否互为变形词。
 * 举例：
 * strl="123"，str2="231"，返回 true。
 * strl="123"，str2="2331"，返回 false
 */
public class Code_01_ChangeWords {
    public static boolean isDeformation(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for(int i=0; i<chars1.length; i++)
            map[chars1[i]]++;
        for(int i=0; i<chars2.length; i++){
            if(map[chars2[i]]-- == 0)
                return false;
        }
        return true;
    }
}
