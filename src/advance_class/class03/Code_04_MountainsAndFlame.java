package advance_class.class03;

import java.util.Stack;

/**
 * 给一个数组，代表环形的山
 * 1、每座山上会放烽火，相邻可看见烽火
 * 2、不相邻的山峰，两条路中其中一条路上的烽火都不大于他们之间的最小值，就能看见
 * 返回能相互看见的山峰有多少对？
 */
public class Code_04_MountainsAndFlame {
    public static class Pair{
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public static long communications(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int maxIndex = 0;
        for(int i=0; i<array.length; i++){
            maxIndex = array[i] > array[maxIndex] ? i : maxIndex;
        }
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(array[maxIndex]));
        int index = nextIndex(maxIndex, array.length);
        long res = 0L;
        while(index != maxIndex){
            if(!stack.isEmpty() && array[index] > stack.peek().value){
                int times = stack.peek().times;
                res += getInteralSum(times) + 2*times;
            }
            if(!stack.isEmpty() && stack.peek().value == array[index])
                stack.peek().times++;
            else
                stack.push(new Pair(array[index]));
            index = nextIndex(index, array.length);
        }
        while(!stack.isEmpty()){
            int times = stack.peek().times;
            res += getInteralSum(times);
            if(!stack.isEmpty()){
                res += times;
                if(stack.size() > 1){
                    res += times;
                }else{
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }

    public static long getInteralSum(int n){
        return n == 1L ? 0L : (long)n * (long)(n-1) / 2L;
    }

    public static int nextIndex(int maxIndex, int size){
        return (maxIndex + 1) % size;
    }
}
