package basic_class.class06;

/**
 * 给定一个二维数组，其中每个数都是正数。要求从左上角走到右下角，每一步只能向右或者向下。
 * 沿途经过的数字要累加起来。返回最小的路径和。
 */
public class Code_07_MinPath {

    // 暴力递归：从(i,j)位置开始，到矩阵右下角的路径和
    public static int getMinPath(int[][] mat, int i, int j){
        if(mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0)
            return 0;
        if(i == mat.length - 1 && j == mat[0].length - 1)
            return mat[i][j];
        if(i == mat.length - 1)
            return mat[i][j] + getMinPath(mat, i, j+1);
        if(j == mat[0].length - 1)
            return mat[i][j] + getMinPath(mat, i+1, j);
        int right = getMinPath(mat, i, j+1);
        int down = getMinPath(mat, i+1, j);
        return mat[i][j] + Math.min(right, down);
    }

    // 动态规划
    public static int getMinPath2(int[][] mat){
        if(mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0)
            return 0;
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = mat[0][0];
        for(int i=1; i<rows; i++)
            dp[i][0] = dp[i-1][0] + mat[i][0];
        for(int j=1; j<cols; j++)
            dp[0][j] = dp[0][j-1] + mat[0][j];
        for(int i=1; i<rows; i++){
            for(int j=1; j<rows; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + mat[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }


}
