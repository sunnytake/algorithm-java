package basic_class.class02;

/**
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_05_RotateMatrix {

    public static void rotateMatrix(int[][] matrix){
        int leftUpRow = 0;
        int leftUpCol = 0;
        int rightDownRow = matrix.length - 1;
        int rightDownCol = matrix[0].length - 1;

        while(leftUpRow <= rightDownRow && leftUpCol <= rightDownCol){
            rotateEdge(matrix, leftUpRow++, leftUpCol++, rightDownRow--, rightDownCol--);
        }
    }

    public static void rotateEdge(int[][] matrix, int leftUpRow, int leftUpCol, int rightDownRow, int rightDownCol){
        int times = rightDownCol - leftUpCol;
        int temp;
        for(int i=0; i<times; i++){
            temp = matrix[leftUpRow][leftUpCol + i];
            matrix[leftUpRow][leftUpCol + i] = matrix[rightDownRow - i][leftUpCol];
            matrix[rightDownRow - i][leftUpCol] = matrix[rightDownRow][rightDownCol - i];
            matrix[rightDownRow][rightDownCol - i] = matrix[leftUpRow+i][rightDownCol];
            matrix[leftUpRow+i][rightDownCol] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }


}
