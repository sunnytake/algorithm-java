package advance_class.class03;

import java.util.Stack;

/**
 * 最大子矩阵的大小
 * 给定一个整型矩阵map，其中的值只有0,1两种，求其中全是1 的所有矩阵区域中，最大的矩形区域为1的数量。
 * 例如：
 * 　　1  1  1  0
 * 其中最大的矩形区域有3个1，所以返回3
 *
 *例如：
 * 　　1  0  1  1
 *    1  1  1  1
 * 　　1  1  1  0
 * 其中，最大的矩形区域有6个1，所以返回6
 */
public class Code_03_MaximalRectangle {
    public static int maxRecSize(int[][] mat) {
        int max = Integer.MIN_VALUE;
        // 以当前行为底的连续为1的列的高度
        int[] heights = new int[mat[0].length];
        for(int i=0; i< mat.length; i++){
            for(int j=0; j<mat[0].length; j++)
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + 1;
            Stack<Integer> stack = new Stack<>(); // 栈底到栈顶满足从小到大
            for(int j=0; j<heights.length; j++){
                while(!stack.isEmpty() && heights[j] <= heights[stack.peek()]){
                    Integer popIndex = stack.pop();
                    int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                    int rightIndex = j;
                    int area = (rightIndex - leftIndex - 1) * heights[popIndex];
                    max = Math.max(area, max);
                }
                stack.push(j);
            }

            while(!stack.isEmpty()){
                Integer popIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = heights.length;
                int area = (rightIndex - leftIndex - 1) * heights[popIndex];
                max = Math.max(area, max);
            }
            stack.push(i);

        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1,1,1,0}};
        int[][] mat2 = {{1,0,1,1}, {1,1,1,1}, {1,1,1,0}};
        int[][] mat3 = new int[][]{
                {0,1,0,0,0,0},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1}
        };
        System.out.println(maxRecSize(mat1));
        System.out.println(maxRecSize(mat2));
        System.out.println(maxRecSize(mat3));
    }
}
