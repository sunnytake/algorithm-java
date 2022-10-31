package advance_class.class01;

/**
 * 问题：给定一个字符串str1，只能往str1的后面添加字符变成str2，要求str2 整体都是回文串且最短。
 * 举例：str1 = ABC12321, 返回ABC12321CBA
 * 整个题意就是要求字符串str1的最后一个字符开始，判断往前计算最大回文串长度，之后再把非回文串的长度逆序后添加到字符串str1末尾形成新的字符串str2并返回。
 * 解题思路：计算整个回文半径数组P_arr，当计算到有半径刚压中最后字符串最后一个字符时，即可确定整个回文字符串的长度，将回文直径之前的数据逆序后添加至原字符串末尾。
 */
public class Code_04_ShortestPralidrome {

    public static char[] manacherString(String str){
        char[] chars = str.toCharArray();
        char[] manacherChars = new char[2 * chars.length + 1];
        int index = 0;
        for(int i=0; i<manacherChars.length; i++){
            manacherChars[i] = (i&1) == 0 ? '#' : chars[index++];
        }
        return manacherChars;
    }

    public static String getShortestPralidrome(String str){
        if(str == null || str.length() == 0)
            return str;

        char[] manacherChars = manacherString(str);
        int[] pArr = new int[manacherChars.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for(int i=0; i<manacherChars.length; i++){
            if(i < pArr[i]){
                pArr[i] = Math.min(pArr[2*index-i], pR-i);
            }else{
                pArr[i] = 1;
            }
            while(i+pArr[i] < manacherChars.length && i-pArr[i]>-1){
                if(manacherChars[i+pArr[i]] == manacherChars[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
            if(pR == manacherChars.length){
                maxContainsEnd = pArr[i];
                break;
            }
        }

        char[] res = new char[str.length() - maxContainsEnd + 1];
        for(int i=0; i<res.length; i++){
            res[res.length - 1 - i] = manacherChars[i*2 + 1];
        }
        return String.valueOf(res);
    }

}
