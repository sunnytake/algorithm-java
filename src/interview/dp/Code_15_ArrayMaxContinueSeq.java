package interview.dp;

import java.util.HashMap;

/**
 * 问题：数组中的最长连续序列
 * 题目：
 * 给定无序数组array，返回其中最长的连续序列的长度
 * 举例：
 * array=[100,4,200,1,3,2]，最长的连续序列为[1,2,3,4]，所以返回4
 */
public class Code_15_ArrayMaxContinueSeq {
    public static int getMaxContinueSeq(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], 1);
                if(map.containsKey(array[i]-1)){
                    max = Math.max(max, merge(map, array[i]-1, array[i]));
                }
                if(map.containsKey(array[i]+1)){
                    max = Math.max(max, merge(map, array[i], array[i] + 1));
                }
            }
        }
        return max;
    }

    public static int merge(HashMap<Integer,Integer> map, int less, int more){
        int left = less - map.get(less) + 1;
        int right = more - map.get(more) - 1;
        int length = right - left + 1;
        map.put(left, length);
        map.put(right, length);
        return length;
    }
}
