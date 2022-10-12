package basic_class.class01;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
 * 间复杂度O(N)，且要求不能用非基于比较的排序
 */
public class Code_11_MaxGap {

    public static int bucket(int num, int len, int minVal, int maxVal){
        return (int)((num - minVal) * len / (maxVal - minVal));
    }

    public static int maxGap(int[] array){
        if(array == null || array.length < 2)
            return 0;

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            maxVal = Math.max(maxVal, array[i]);
            minVal = Math.min(minVal, array[i]);
        }

        if(minVal == maxVal)
            return 0;

        int len = array.length;
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid=0;
        for(int i=0; i<array.length; i++){
            bid = bucket(array[i], len, minVal, maxVal);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], array[i]) : array[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], array[i]) : array[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for(int i=1; i<=len; i++){
            if(hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

}
