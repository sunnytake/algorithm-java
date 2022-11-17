package interview.dandiaostack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目：
 * 给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 * 例如：
 * 输入：array = {3,4,1,5,6,2,7}
 * 输出：{{-1,2},{0,2},{-1,-1},{2,5},{3,5},{2,-1},{5,-1}}
 *
 * 进阶：
 * 给定一个可能含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 */
public class Code_06_DandiaoStack_1 {

    // 不含重复值
    public static int[][] findDoubleBig(int[] array) {
        int[][] res = new int[array.length][2];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
                Integer index = stack.pop();
                if (!stack.isEmpty())
                    res[index][0] = stack.peek();
                else
                    res[index][0] = -1;
                res[index][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            if (!stack.isEmpty())
                res[index][0] = stack.peek();
            else
                res[index][0] = -1;
            res[index][1] = -1;
        }
        return res;
    }

    // 含有重复值
    public static int[][] findDoubleBigPro(int[] array){
        int[][] res = new int[array.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i=0; i<array.length; i++){
            while(!stack.isEmpty() && array[stack.peek().get(0)] > array[i]){
                List<Integer> popIndexs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for(int popIndex : popIndexs){
                    res[popIndex][0] = leftLessIndex;
                    res[popIndex][1] = i;
                }
            }
            if(!stack.isEmpty() && array[stack.peek().get(0)] == array[i])
                stack.peek().add(i);
            else{
                ArrayList<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                stack.push(indexs);
            }
        }
        while(!stack.isEmpty()){
            List<Integer> popIndexs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for(int popIndex : popIndexs){
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = {3,4,1,5,6,2,7};
        int[][] res = findDoubleBig(array);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i][0] + "\t" + res[i][1]);
        }
    }

}
