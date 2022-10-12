package basic_class.class01;

/**
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数
 * 组的左边，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Code_14_SplitSeq {

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void splitSeq2(int[] array, int num, int left, int right){
        int lessEqual = left-1;
        int cur = left;

        while(cur <= right){
            if(array[cur] <= num){
                swap(array, ++lessEqual, cur++);
            }else{
                cur++;
            }
        }
    }


    public static void splitSeq(int[] array, int num){
        if(array == null || array.length < 2)
            return;
        int left = 0;
        int right = array.length - 1;

        while(left < right){
            while(left<right && array[left] < num)
                left++;
            while(left<right && array[right] >= num)
                right--;
            if(left<right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
    }

}
