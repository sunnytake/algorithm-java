package basic_class.class01;

/**
 * 问题二（荷兰国旗问题）
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的
 * 左边，等于num的数放在数组的中间，大于num的数放在数组的
 * 右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N
 */
public class Code_08_NetherlandsFlag {

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] netherlandsFlag(int[] array, int num, int left, int right){
        int less = left-1;
        int more = right + 1;
        int cur = left;
        while(cur < more){
            if(array[cur] < num){
                swap(array, cur++, ++less);
            }else if(array[cur] > num){
                swap(array, cur, --more);
            }else{
                cur++;
            }
        }
        return new int[] {less+1, more-1};
    }

}
