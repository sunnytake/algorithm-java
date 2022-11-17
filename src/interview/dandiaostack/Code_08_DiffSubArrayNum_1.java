package interview.dandiaostack;

import java.util.LinkedList;

/**
 * 题目：
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * max（arr[i..j]）表示子数组arr[i..j]中的最大值，min（arr[i..j]）表示子数组arr[i..j]中的最小值
 */
public class Code_08_DiffSubArrayNum_1 {

    public static int getDiffSubArrayNum(int[] array, int num){
        if(array == null || array.length == 0)
            return 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i < array.length){
            while(j < array.length){
                while(!qmax.isEmpty() && array[qmax.peekLast()] < array[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while(!qmin.isEmpty() && array[qmin.peekLast()] > array[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if(array[qmax.peekLast()] - array[qmin.peekLast()]  > num)
                    break;
                j++;
            }
            res += j - i;
            if(qmax.peekFirst() == i)
                qmax.pollFirst();
            if(qmin.peekFirst() == i)
                qmin.pollFirst();
            i++;
        }
        return res;
    }

}
