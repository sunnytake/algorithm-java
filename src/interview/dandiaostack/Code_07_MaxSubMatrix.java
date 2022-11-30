package interview.dandiaostack;

import java.util.Stack;

/**
 * 题目：
 * 给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 * 输入：1 1 1 0
 * 输出：最大的矩形区域有3个1，所以返回3
 * 输入：
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 输出：最大的矩形区域有6个1，所以返回6
 */
public class Code_07_MaxSubMatrix {

    public static Integer getMaxSubMatrix(int[][] mat){
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            return null;
        int[] heights = new int[mat[0].length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<mat.length; i++){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j=0; j<mat[0].length; j++){
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + mat[i][j];
            }
            for(int j=0; j<heights.length; j++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    Integer index = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int right = j;
                    int area = (right - left - 1) * heights[index];
                    maxArea = Math.max(area, maxArea);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                Integer index = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = heights.length;
                int area = (right - left - 1) * heights[index];
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 1, 1, 0}};
        System.out.println(getMaxSubMatrix(mat1));

        int[][] mat2 = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(getMaxSubMatrix(mat2));
    }

}
