package interview.dp;

/**
 * 问题：矩阵的最小路径和
 * 给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 如果给定的m如下：
 * 1    3   5   9
 * 8    1   3   4
 * 5    0   6   1
 * 8    8   4   0
 * 路径1,3,1,0,6,1,0是所有路径中路径和最小的，所以返回12
 */
public class Code_02_MatrixMinPath {

    public static int findMinPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int i=1; i<=matrix.length; i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(int j=1; j<matrix[0].length; j++){
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return matrix[matrix.length-1][matrix[0].length-1];
    }

}
