package interview.string;

/**
 * 问题：数组中两个字符串的最小举例
 * 题目：
 * 给定一个字符串数组 strs，再给定两个字符串strl和str2，返回在strs中strl与str2的最小距离，如果strl或str2为null，或不在strs 中，返回-1。
 * 举例：
 * strs=["1"."3""3"."3","2"."3""1”]，strl="1"，str2="2"，返回2
 * strs=["CD”]，strl="CD"，str2="AB”，返回-1。
 * 进阶：
 * 如果查询发生的次数有很多，如何把每次查询的时间复杂度降为 O(1)?
 */
public class Code_12_StrMinDisInArray {

    public static int minDistance(String[] strs, String str1, String str2){
        if(str1 == null || str2 == null)
            return -1;
        if(str1.equals(str2))
            return 0;
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i!=strs.length; i++){
            if(strs[i].equals(str1)){
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if(strs[i].equals(str2)){
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
