package interview.dp;

/**
 * 问题：龙与地下城游戏问题
 * 题目：
 * 给定一个二维数组 map，含义是一张地图，例如，如下矩阵:
 * -2   -3   3
 * -5   -10  1
 * 0    30   -5
 * 游戏的规则如下:
 * 骑士从左上角出发，每次只能向右或向下走，最后到达右下角见到公主
 * 地图中每个位置的值代表骑士要遭遇的事情。如果是负数，说明此处有怪兽，要让骑士损失血量。如果是非负数，代表此处有血瓶，能让骑士回血。
 * 骑士从左上角到右下角的过程中，走到任何一个位置时，血量都不能少于1为了保证骑士能见到公主，初始血量至少是多少?
 * 根据 map，返回初始血量。
 */
public class Code_10_DragonGame {

    public static int getMinHp(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 1;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = matrix[row][col] > 0 ? 1 : -matrix[row][col] + 1;
        for(int j=col-1; j>=0; j--)
            dp[row][col] = Math.max(dp[row][col+1] - matrix[row][col], 1);
        int right = 0;
        int down = 0;
        for(int i=row-1; i>=0; i--){
            dp[i][col] = Math.max(dp[i+1][col] - matrix[i][col], 1);
            for(int j=col-1; j>=0; j--){
                right = Math.max(dp[i][j+1] - matrix[i][j], 1);
                down = Math.max(dp[i+1][j] - matrix[i][j], 1);
                dp[i][j] = Math.max(right, down);
            }
        }
        return dp[0][0];
    }

}


















