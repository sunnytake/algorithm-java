package advance_class.class02;

import java.util.LinkedList;

/**
 * 题目：
 * 给定数组 arr 和整数 num,共返回有多少个子数组满足如下情况:
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * max(arr[i..j])表示子数组 arr[i..j]中的最大值,min(arr[i..j])表示子数组 arr[i..j]中的最 小值。
 * 如果数组长度为 N,请实现时间复杂度为 O(N)的解法。
 */
public class Code_02_MinMaxGapChildArray {

    public static int getNum(int[] array, int num){
        if(array == null || array.length == 0)
            return 0;
        LinkedList<Integer> minIndexQueue = new LinkedList<Integer>();
        LinkedList<Integer> maxIndexQueue = new LinkedList<Integer>();

        int left = 0;
        int right = 0;
        int res = 0;

        while(left < array.length){
            while(right < array.length){
                while(!minIndexQueue.isEmpty() && array[right] <= array[minIndexQueue.peekLast()])
                    minIndexQueue.pollLast();
                minIndexQueue.add(right);
                while(!maxIndexQueue.isEmpty() && array[right] >= array[maxIndexQueue.peekLast()])
                    maxIndexQueue.pollLast();
                maxIndexQueue.add(right);
                if(array[maxIndexQueue.peekFirst()] - array[minIndexQueue.peekFirst()] > num)
                    break;
                right++;
            }
            if(minIndexQueue.peekFirst() == left)
                minIndexQueue.pollFirst();
            if(maxIndexQueue.peekFirst() == left)
                maxIndexQueue.pollFirst();
            res += right - left;
            left++;
        }
        return res;
    }

}
