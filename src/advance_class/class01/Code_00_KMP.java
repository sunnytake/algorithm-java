package advance_class.class01;

/**
 * KMP算法的应用场景（连续子串）：str1中是否包含str2，如果包含则返回字符串str2在字符串str1中的起始位置。如果不包含则返回-1。
 * 求解前缀和后缀相等的最长长度。
 * 例如：
 * aaaab，求解b位置的信息时，只考虑b位置前面的字符串。保证前面的字符不移动到最后一位，最后一位的字符不移动到第0位。当为1时，两个相等，当为2时，两个也相等，当为3时，两个字符串也相等。结束，此时最长的长度为3。
 * abcabcd，求解d位置的信息时，当前缀为1（后缀也为1）的时候不相等，因为a不等于c，当前缀为2时，不相等，因为ab不等于bc，当前缀为3的时候，abc等于abc，所以记录。当前缀为4的时候，不相等，因为abca不等cabc。当前缀为5时，abcab不等bcabc，所以整个过程求解的结果为3。
 * 对于复杂度分析：求解next数组的过程是对str2进行求解，求解过程的复杂度为O(M)，使用KMP算法的时间复杂度为O(N)，两者为加关系，即O(M+N)，又由于M<N，所以最后整个算法的时间复杂度为O(N)。
 * next数组求解：整个求解过程是不断往前跳的。人为规定next数组的0号位置为-1，1号位置为0。如果前一个数的最长前缀的下一个位置为前一个数的值，则当前位置的信息为前一个数的值递增1。如果不等于，则将前一个数的最长前缀进行划分，求解不等那个数的最长前缀值的下一个位置，判断是否等于当前位置的前一个数。
 * 初始状态为：
 * str : x0 x1 x2 x3 ... next : -1 0 index: 0 1 2 3 ...
 */
public class Code_00_KMP {

    public static int kmp(String s, String t){
        if(s == null || t == null || t.length() < 1 || s.length() < t.length())
            return -1;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        int[] nexts = getNextArray(tChars);
        while(sIndex < sChars.length && tIndex < tChars.length){
            if(sChars[sIndex] == tChars[tIndex]){
                sIndex++;
                tIndex++;
            }else{
                // 只有tIndex = 0时才为-1
                if(nexts[tIndex] == -1)
                    sIndex++;
                else
                    tIndex = nexts[tIndex];
            }
        }
        return tIndex == tChars.length ? sIndex - tIndex : -1;
    }

    public static int[] getNextArray(char[] chars){
        if(chars.length == 1)
            return new int[]{-1};
        // 不为1，则必定大于等于2
        int[] nexts = new int[chars.length];
        nexts[0] = -1;
        nexts[1] = 0;
        int i = 2;
        int cn = 0; // 最长匹配长串所压中的下一个位置
        while(i < nexts.length){
            if(chars[i-1] == chars[cn]){
                // 由于长度改变，cn的值需要递增1
                nexts[i++] = ++cn;
            // 如果cn位置的值没有配上，则cn要划出自己的前缀信息
            // 所以此处更新cn的值
            // 此时就拿出在next数组中存储在cn位置的值继续与原来的数值进行比对
            }else if(cn > 0){
                cn = nexts[cn];
            }else{
                // cn不能往前跳了，防止其变为负值，设置为0值
                nexts[i++] = 0;
            }
        }
        return nexts;
    }


}
