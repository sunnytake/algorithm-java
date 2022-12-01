package interview.dp;

/**
 * 问题：跳跃游戏
 * 问题：
 * 给定数组arr，arr[i]=k 代表可以从位置i向右跳1~k个距离。比如，arr[2]=3，代表从位置 2可以跳到位置 3、位置 4 或位置 5。如果从位置0出发，返回最少跳几次能跳到arr最后的位置上
 * 举例：
 * arr=[3,2,3,1,1,4]
 * arr[0]=3,选择调到位置2；arr[2]=3，可以跳到最后的位置，所以返回2.
 */
public class Code_14_JumpGame {
    public static int jump(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int jump = 0; // 跳的次数
        int cur = 0; // 最远能到达的位置
        int next = 0; //如果再多跳一部，最远能够到达的位置
        for(int i=0; i<array.length; i++){
            if(cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next, i+array[i]);
        }
        return jump;
    }
}
