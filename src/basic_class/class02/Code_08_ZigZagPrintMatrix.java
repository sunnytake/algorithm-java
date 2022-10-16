package basic_class.class02;

/**
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如：
 * 1 2  3  4
 * 5 6  7  8
 * 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_08_ZigZagPrintMatrix {

    public static void zigZagPrintMatrix(int[][] matrix){
        int rightUpRow = 0;
        int rightUpCol = 0;
        int leftDownRow = 0;
        int leftDownCol = 0;
        boolean printSeq = false; // 从上往下打，还是从下往上打

        while (rightUpRow < matrix.length && rightUpCol < matrix[0].length){
            printEdge(matrix, rightUpRow, rightUpCol, leftDownRow, leftDownCol, printSeq);
            if(rightUpCol < (matrix[0].length - 1))
                rightUpCol++;
            else
                rightUpRow++;
            if(leftDownRow < (matrix.length - 1))
                leftDownRow++;
            else
                leftDownCol++;
            printSeq = !printSeq;
        }
    }

    public static void printEdge(int[][] matrix, int rightUpRow, int rightUpCol, int leftDownRow, int leftDownCol, boolean printSeq){
        if(printSeq){
            //从上往下打
            for(int i=0; i<=leftDownRow-rightUpRow; i++){
                System.out.println(matrix[rightUpRow+i][rightUpCol-i] + ", ");
            }
        }else{
            for(int i=0; i<=leftDownRow-rightUpRow; i++){
                System.out.println(matrix[leftDownRow-i][leftDownCol+i] + ", ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigZagPrintMatrix(matrix);
    }

}
