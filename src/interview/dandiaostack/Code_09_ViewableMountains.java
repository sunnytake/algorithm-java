package interview.dandiaostack;

import java.util.Stack;

/**
 * 题目：
 * 一个不含有负数的数组可以代表一圈环形山，每个位置的值代表山的高度。
 * 比如，{3，1，2，4，5}、{4，5，3，1，2} 或 {1，2，4，5，3}都代表同样结构的环形山。
 * 3-＞1-＞2-＞4-＞5-＞3方向叫作next方向（逆时针），3-＞5-＞4-＞2-＞1-＞3方向叫作last方向（顺时针），
 * 山峰A和山峰B能够相互看见的条件为：
 * 1.如果A和B是同一座山，认为不能相互看见。
 * 2.如果A和B是不同的山，并且在环中相邻，认为可以相互看见。
 * 比如上例中，相邻的山峰对有（1，2）（2，4）（4，5）（3，5）（1，3）。
 * 3.如果A和B是不同的山，并且在环中不相邻，假设两座山高度的最小值为min。
 * 如果A通过next方向到B的途中没有高度比min大的山峰，或者A通过last方向到B的途中没有高度比min大的山峰，认为A和B可以相互看见。
 */
public class Code_09_ViewableMountains {
    static class Record{
        public int value;
        public int times;

        public Record(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static int getInternalSum(int k){
        return k == 1 ? 0 : (k * (k-1) / 2);
    }

    public static int getVisableMountainsNum(int[] array){
        if(array == null || array.length < 2)
            return 0;
        Stack<Record> stack = new Stack<Record>();
        int maxIndex = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > array[maxIndex])
                maxIndex = i;
        }
        stack.push(new Record(array[maxIndex]));
        int index = (maxIndex + 1) % array.length;
        int res = 0;
        while(index != maxIndex){
            while(!stack.isEmpty() && stack.peek().value < array[index]){
                int times = stack.pop().times;
                res += getInternalSum(times) + 2 * times;
            }
            if(!stack.isEmpty() && stack.peek().value == array[index]){
                stack.peek().times++;
            }else{
                stack.push(new Record(array[index]));
            }
            index = (index + 1) % array.length;
        }

        while(stack.size() > 2){
            int times = stack.pop().times;
            res += getInternalSum(times) + 2 * times;
        }
        if(stack.size() == 2){
            int times = stack.pop().times;
            res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
        }
        res += getInternalSum(stack.pop().times);
        return res;
    }


}

















