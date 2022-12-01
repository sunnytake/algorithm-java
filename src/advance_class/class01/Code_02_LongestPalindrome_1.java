package advance_class.class01;

/**
 * 回文是指正着读和倒着读，结果一些样，比如abcba或abba。
 * 题目是要在一个字符串中要到最长的回文子串。
 */
public class Code_02_LongestPalindrome_1 {

    /**
     *在一个字符串中找到最长的回文字符串：
     * 以每个位置作为中心，向两边扩展，可以确定奇回文，但是偶回文无法这样做。
     * 解决方法：在字符串中间及两边插入某种字符，此时可以按照这种方法进行扩展。此时无论奇回文还是偶回文都可以找到。
     * 例如11211，此时添加任意字符在两边#1#1#2#1#1#此时均可以进行回文判断。
     *
     * 补充概念：
     * 回文直径：以一个位置为中心，扩出来整个串的长度为回文直径
     * 回文半径：以一个位置为中心，扩出来半个串长度为回文半径
     * 回文数组：对于字符串而言，从0位置开始，一直到最后，新建一个数组，数组中保存对应位置的回文半径。
     * 最右回文右边界：所有回文半径中，最靠右的边界，回文右边界只要没更新，记录最早取得此处的回文中心。
     *
     * Manacher算法详解：
     * Manacher在向外扩展的过程整体跟之前的算法相似，但是有加速。
     * 回文右边界R不包含位置i，此时暴力扩展，直到R包含i。
     * i位置在回文右边界内时，知道了回文右边界可以知道回文左边界，对称中心为c，此时关于c做i的对称点i‘，若i‘的回文彻底在c为中心的回文里面，此时i的回文半径和i’的回文半径相同。
     * i位置的对称位置i’的回文半径越过了以c为中心的左边范围。（i‘扩出的范围以c为中心的回文没包住，存在一部分在回文直径外面）此时i’的回文半径是i-R。
     * 正好i‘的回文半径正好跟左边L相等，此时可以直到i的回文半径大于等于i-R，然后需要判断R后面的位置，重新返回第一步。
     * 整个算法的复杂度O(n)，虽然第一步和第四步花费时间长，但是1，4都会扩展R，依次变化的过程中，R最多也就是变化到n，所以时间复杂度为O(n)。
     * 参考博客：https://www.jianshu.com/p/116aa58b7d81
     * @param str
     * @return
     */
    public static String findLongestPalindrome4(String str) {
        if (str == null || str.length() == 0 || str.length() == 1)
            return str;

        // 将原始字符串变为适用于manacher算法的字符串
        // "abc1234321ab"->"#a#b#c#1#2#3#4#3#2#1#a#b#"
        char[] chars = str.toCharArray();
        char[] manacherChars = new char[chars.length * 2 + 1];
        int index = 0;
        // 往其中添加字符，偶数情况添加#字符，奇数情况添加原字符(保证每个字符两侧都有#)
        for (int i = 0; i < manacherChars.length; i++)
            manacherChars[i] = (i & 1) == 0 ? '#' : chars[index++];


        //Manacher算法本体
        // 回文半径数组
        int[] pArr = new int[manacherChars.length];
        // 回文中心位置
        index = -1;
        // 回文最右边界
        int pR = -1;

        for(int i=0; i<manacherChars.length; i++){
            // 在右边界内
            if(i < pR){
                pArr[i] = Math.min(pArr[2*index-i], pR - i);
            }else{
                pArr[i] = 1;
            }
            while(i + pArr[i] < manacherChars.length && i - pArr[i] > -1){
                if(manacherChars[i+pArr[i]] == manacherChars[i-pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if(i + pArr[i] > pR){
                pR = i + pArr[i];
                index = i;
            }
        }

        // 待返回的回文的中心，以及回文半径
        int max = Integer.MIN_VALUE;
        for(int i=0; i<pArr.length; i++){
            if(pArr[i] > max){
                max = pArr[i];
                index = i;
            }
        }
        return str.substring((index-pArr[index]+1)/2, (index+pArr[index])/2);
    }

    /**
     * 方法3：动态规划法。用动态规划来做上面的那个例题，dp[N][N]来存状态，dp[ i] [ j ]=1,表示字符串从i到j为回文串。
     * （1）当str[ i ]==str[ j ]时，dp[i+1][j-1]=1,则dp[ i ][ j ]=1 ( [i+1,j-1]为回文串，且str[ i ]==str[ j ]则[i,j]为回文串 ),否则dp[ i ][ j ]=0。
     * （2）当str[ i ]!=str[ j ]时,dp[ i ][ j ]=0。
     * 在遍历方面也要注意，如果按照i和j从小到大的顺序来枚举子串的两个端点,然后更新dp[i][j],会无法保证dp[i + 1][j - 1]已经被计算过,从而无法得到正确的dp[i][i]。
     * 我们可以遍历长度，长度从小到达依次增加，每次判断出左右端点即可。
     * @param str
     * @return
     */
    public static String findLongestPalindrome3(String str){
        if(str == null || str.length() == 0 || str.length() == 1)
            return str;

        int length = str.length();
        char[] chars = str.toCharArray();
        boolean[][] dp = new boolean[length][length];
        for(int i=0; i<length; i++){
            dp[i][i] = true;
            if(i<length-1 && chars[i] == chars[i+1]){
                dp[i][i+1] = true;
            }
        }
        for(int len=3; len<=length; len++){
            for(int i=0; i+len-1<length; i++){
                int j = i + len - 1;
                if(chars[i] == chars[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }
        String res = null;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(dp[i][j] && (res == null || (j-i+1) > res.length())){
                    res = str.substring(i, j+1);
                }
            }
        }
        return res;
    }

    /**
     * 方法2：中心扩散法。由于回文串是对称的，所以我们可以枚举所有的中点，再向两侧扩散，时间复杂度为O（n^2）
     * @param str
     * @return
     */
    public static String findLongestPalindrome2(String str){
        if(str == null || str.length() == 0 || str.length() == 1)
            return str;

        String result = null;
        char[] chars = str.toCharArray();

        for(int i=0; i<str.length(); i++){
            // 奇数长度的回文子串，以i为中心
            int left = i-1;
            int right = i+1;
            while(left >= 0 && right < str.length()){
                if(chars[left] == chars[right]){
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(result == null || (right-left > result.length()))
                result = str.substring(left+1, right);

            // 偶数长度的回文子串
            left = i;
            right = i+1;
            while(left >= 0 && right < str.length()){
                if(chars[left] == chars[right]){
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(result == null || (right-left > result.length()))
                result = str.substring(left+1, right);
        }
        return result;
    }


    /**
     * 方法1：暴力破解法。求出每一个子串，之后判断是不是回文，找到最长的那个。
     * 求每一个子串时间复杂度O(N^2)，判断子串是不是回文O(N)，两者是相乘关系，所以时间复杂度为O(N^3)。
     * @param str
     * @return
     */
    public static String findLongestPalindrome1(String str){
        if(str == null || str.length() == 0 || str.length() == 1)
            return str;
        String result = null;
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++){
            for(int j=i+1; j<chars.length; j++){
                int left = i;
                int right = j;
                // 依次判断
                while(left < right){
                    if(chars[left] == chars[right]){
                        left++;
                        right--;
                    }else{
                        break;
                    }
                }
                // 验证结果
                if(result == null || (left >= right && (j - i) > result.length())){
                    result = str.substring(i, j+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "cdeabcbafgh";
        String str2 = "aa";
        System.out.println("======================findLongestPalindrome1=====================");
        System.out.println(findLongestPalindrome1(str1));
        System.out.println(findLongestPalindrome1(str2));
        System.out.println("======================findLongestPalindrome2=====================");
        System.out.println(findLongestPalindrome2(str1));
        System.out.println(findLongestPalindrome2(str2));
        System.out.println("======================findLongestPalindrome3=====================");
        System.out.println(findLongestPalindrome3(str1));
        System.out.println(findLongestPalindrome3(str2));
        System.out.println("======================findLongestPalindrome4=====================");
        System.out.println(findLongestPalindrome4(str1));
        System.out.println(findLongestPalindrome4(str2));
    }
}
