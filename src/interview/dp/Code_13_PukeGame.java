package interview.dp;

/**
 * 问题：排成一条线的纸牌博弈问题
 * 题目：
 * 给定一个整型数组 arr，代表数值不同的纸牌排成一条线。玩家 A 和玩家 B依次拿走每张纸牌，规定玩家A 先拿,玩家 B 后拿，但是每个玩家每次只能拿走最左或最右的纸牌玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 * 举例：
 * arr=[1,2,100,4]。
 * 开始时玩家A只能拿走1或4。如果玩家A拿走1，则排列变为[2,1004]，
 * 接下来玩家B可以拿走2或4然后继续轮到玩家 A。
 * 如果开始时玩家A拿走4则排列变为[1,2,100]
 * 接下来玩家B可以拿走1或100，然后继续轮到玩家 A。
 * 玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100。
 * 所以玩家A会先拿1，让排列变为[2,100.4]，接下来玩家B不管怎么选，100都会被玩家A拿走
 * 玩家A会获胜分数为101所以返回101
 * arr=[1.100.2]。
 * 开始时玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家 B会获胜，分数为100。所以返回100。
 */
public class Code_13_PukeGame {

    public static int win2(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int n = array.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for(int j=0; j<array.length; j++){
            f[j][j] = array[j];
            for(int i=j-1; i>=0; i--){
                f[i][j] = Math.max(array[i] + s[i+1][j], array[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return Math.max(f[0][array.length-1], s[0][array.length-1]);
    }

    //O(2^N)
    public static int win1(int[] array){
        if(array == null || array.length == 0)
            return 0;
        return Math.max(f(array, 0, array.length-1), s(array, 0, array.length-1));
    }

    // array[i...j]这个排列上的纸牌被绝顶聪明的人先拿，最终能得到的分数
    public static int f(int[] array, int i, int j){
        if(i == j)
            return array[i];
        return Math.max(array[i] + s(array, i+1, j), array[j] + s(array, i, j-1));
    }

    // array[i...j]这个排列上的牌被绝顶聪明的人后拿，最终能获得什么分数
    public static int s(int[] array, int i, int j){
        if(i == j)
            return 0;
        return Math.min(f(array, i+1, j), f(array, i, j-1));
    }

}
