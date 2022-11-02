package advance_class.class03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Code_01_SingleStack {

    /**
     * 一个数组中每一个数，得到左边最近的比它大的和右边最近的比它大的数（小的话同理），代价尽量低
     * 没有重复值的数组
     */
    public static int[][] getNearBiggerNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<Integer>();

        // 左边第一个大于 arr[i] 的数：arr[i]进栈时碰到的第一个无法出栈的数
        // 右边第一个大于 arr[i] 的数：第一个将arr[i]弹出栈的数
        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int popIndex = stack.pop();
                int leftBiggerIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftBiggerIndex;
                res[popIndex][1] = i;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftBiggerIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftBiggerIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    /**
     * 一个数组中每一个数，得到左边最近的比它大的和右边最近的比它大的数（小的话同理），代价尽量低
     * 有重复值的数组
     */
    public static int[][] getNearBigger(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<ArrayList<Integer>> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek().get(0)]){
                ArrayList<Integer> popIndexs = stack.pop();
                int leftBiggerIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                for(Integer popIndex : popIndexs){
                    res[popIndex][0] = leftBiggerIndex;
                    res[popIndex][1] = i;
                }
            }

            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else{
                ArrayList<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                stack.add(indexs);
            }
        }

        while(!stack.isEmpty()){
            ArrayList<Integer> popIndexs = stack.pop();
            int leftBiggerIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
            for(Integer popIndex : popIndexs){
                res[popIndex][0] = leftBiggerIndex;
                res[popIndex][1] = -1;
            }
        }
        return res;
    }

    /**
     * 定义：数组中累积和与最小值的乘积，假设叫做指标A。给定一个数组，请返回子数组中，指标A最大的值
     */
    public int getMax(int[] arr) {
        int[] sums = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            sums[i] = i == 0 ? arr[i] : sums[i-1] + arr[i];
        }

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                Integer popIndex = stack.pop();
                max = Math.max(max, stack.isEmpty() ? sums[i-1] : (sums[i-1] - sums[stack.peek()])) * arr[popIndex];
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            Integer popIndex = stack.pop();
            max = Math.max(max, stack.isEmpty() ? sums[sums.length-1] : (sums[sums.length-1] - sums[stack.peek()])) * arr[popIndex];
        }
        return max;
    }

}
