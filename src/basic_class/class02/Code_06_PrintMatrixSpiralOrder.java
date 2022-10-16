package basic_class.class02;

/**
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_06_PrintMatrixSpiralOrder {

    // 左程云推荐方法，通过限制左上角和右下角元素来打印
    public static void printMatrixSpiralOrder2(int[][] matrix){
        int leftUpRow = 0;
        int leftUpCol = 0;
        int rightDownRow = matrix.length - 1;
        int rightDownCol = matrix[0].length - 1;
        while(leftUpRow <= rightDownRow && leftUpCol <= rightDownCol){
            printEdge(matrix, leftUpRow++, leftUpCol++, rightDownRow--, rightDownCol--);
        }
    }

    public static void printEdge(int[][] matrix, int leftUpRow, int leftUpCol, int rightDownRow, int rightDownCol){
        if(leftUpRow == rightDownRow){
            for(int i=leftUpCol; i<=rightDownCol; i++)
                System.out.print(matrix[leftUpRow][i] + ", ");
        }else if(leftUpCol == rightDownCol){
            for(int i=leftUpRow; i<=rightDownRow; i++)
                System.out.print(matrix[i][leftUpCol] + ", ");
        }else{
            int curRow = leftUpRow;
            int curCol = leftUpCol;
            while(curCol < rightDownCol){
                System.out.print(matrix[leftUpRow][curCol++] + ", ");
            }
            while(curRow < rightDownRow){
                System.out.print(matrix[curRow++][rightDownCol] + ", ");
            }
            while(curCol > leftUpCol){
                System.out.print(matrix[rightDownRow][curCol--] + ", ");
            }
            while(curRow > leftUpRow){
                System.out.print(matrix[curRow--][leftUpCol] + ", ");
            }
        }
    }

    public static void printMatrixSpiralOrder(int[][] array){
        if(array == null || array.length == 0)
            return;
        int row = 0;
        int rows = array.length;
        int col = 0;
        int cols = array[0].length;
        while(row < array.length/2 && col < array[0].length/2){
            printRow(array, row, col, cols-2-col);
            printCol(array, cols-1-col, row, rows-2-row);
            printRow(array, rows-1-row, cols-1-col, col+1);
            printCol(array, col, rows-1-row, row+1);
            row++;
            col++;
        }

        if(row >= array.length/2 && col < array[0].length/2){
            printRow(array, row, col, cols-1-col);
        }else if(row < array.length/2 && col >= array[0].length/2){
            printCol(array, col, row, rows-1-row);
        }
    }

    public static void printRow(int[][] array, int row, int colStart, int colEnd){
        if(colStart <= colEnd){
            for(int i=colStart; i<=colEnd; i++) {
                System.out.println(array[row][i]);
            }
        }else{
            for(int i=colStart; i>=colEnd; i--) {
                System.out.println(array[row][i]);
            }
        }
    }

    public static void printCol(int[][] array, int col, int rowStart, int rowEnd){
        if(rowStart <= rowEnd){
            for(int i=rowStart; i<=rowEnd; i++) {
                System.out.println(array[i][col]);
            }
        }else{
            for(int i=rowStart; i>=rowEnd; i--) {
                System.out.println(array[i][col]);
            }
        }
    }

    public static void main(String[] args) {

        int[][] array = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        printMatrixSpiralOrder2(array);
        System.out.println();
        int[][] array1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixSpiralOrder2(array1);
        System.out.println();
        int[][] array2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        printMatrixSpiralOrder2(array2);

    }
}
