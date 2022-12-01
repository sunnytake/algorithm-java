package interview.dp;

/**
 * 问题：最长递增子序列
 * 题目：给定数组arr，返回arr 的最长递增子序列。
 * 举例：arr=[2,1,5,3,6,4,8,9,7]，返回的最长递增子序列为[1,3.4.8,9].
 *
 */
public class Code_05_MinIncreaseSeq {

    public static int[] getMinIncreaseSeq1(int[] array){
        if(array == null || array.length == 0)
            return null;
        int[] dp = getDp1(array);
        return generateSeq(array, dp);
    }

    // 时间复杂度O(N^2)
    public static int[] getDp1(int[] array){
        int[] dp = new int[array.length];
        for(int i=0; i<array.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(array[i] > array[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    // 时间复杂度O(NlogN)
    public static int[] getDp2(int[] array){
        int[] dp = new int[array.length];
        int[] ends = new int[array.length];
        ends[0] = array[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int mid = 0;
        for(int i=1; i<array.length; i++){
            l = 0;
            r = right;
            while(l <= r){
                mid = (l +r ) / 2;
                if(array[i] > ends[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            right = Math.max(right, 1);
            ends[l] = array[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public static int[] generateSeq(int[] array, int[] dp){
        int len = 0;
        int index = 0;
        // 找到以array[i]结束的最长序列
        for(int i=0; i<dp.length; i++){
            if(dp[i] > len){
                len = dp[i];
                index = i;
            }
        }
        int[] seq = new int[len];
        seq[--len] = array[index];
        for(int i=index-1; i>=0; i--){
            if(array[i] < array[index] && dp[i] == dp[index] - 1){
                seq[--len] = array[i];
                index = i;
            }
        }
        return seq;
    }
}



















