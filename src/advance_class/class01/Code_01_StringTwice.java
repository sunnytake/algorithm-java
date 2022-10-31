package advance_class.class01;

/**
 * 给定一个字符串str1，只能往str1的后面添加字符变成str2。
 * 要求1：str2必须包含两个str1，两个str1可以有重合，但是不能以同一个位置开头。
 * 要求2：str2尽量短 最终返回str2
 *
 * 举例：
 * str1 = 123, str2 = 123123时，包含两个str1，且不以相同位置开头，且str2最短。
 * str1 = 123123, str2 = 123123123时，包含两个str1，且不以相同位置开头，且str2最短。
 * str1 = 111, str2 = 1111时，包含两个str1，且不以相同位置开头，且str2最短。
 * abcabc字符串，在后面增加abc后，形成新的字符串abcabcabc，此时就有两个原来的字符串。
 *
 * 思路：
 * 利用KMP算法进行解决。通过求解整个数组的最后一个位置之后的X元素的next数组，获得最大前缀值，然后再将最大前缀值所表示的字符串加入即可。
 * 例如：abcabc字符串，abcabc#即求字符#处的next数组值，此时求得的结果为3，表示最大前缀值为abc，所以将这个最大前缀直接添加到原字符串后面即。
 */
public class Code_01_StringTwice {

    public static String getMinTwiceString(String str){
        if(str == null || str.length() == 0)
            return "";
        if(str.length() == 1)
            return str + str;
        int[] nexts = getNexts(str.toCharArray());
        System.out.println(nexts[str.length()] + " , " + str.length());
        String substr = str.substring(nexts[str.length()], str.length());
        return str + substr;
    }

    public static int[] getNexts(char[] chars){
        if(chars.length == 1)
            return new int[]{-1, 1};
        int[] nexts = new int[chars.length + 1];
        nexts[0] = -1;
        nexts[1] = 0;
        int i = 2;
        int cn = 0;
        while(i <= chars.length){
            if(chars[i-1] == chars[cn]){
                nexts[i++] = ++cn;
            }else{
                if(cn > 0){
                    cn = nexts[cn];
                }else{
                    nexts[i++] = 0;
                }
            }
        }
        return nexts;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        int[] nexts = getNexts(str.toCharArray());
        for(int next : nexts){
            System.out.println(next);
        }
        System.out.println(getMinTwiceString(str));
        str = "aa";
        System.out.println(getMinTwiceString(str));
    }

}
