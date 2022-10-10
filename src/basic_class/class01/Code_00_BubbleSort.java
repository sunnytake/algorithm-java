package basic_class.class01;

/**
 * 冒泡排序：每次对无序部分从左到右找到一个最大的，放在最后的位置
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] array){
        if(array == null || array.length < 2)
            return;

        for(int end=array.length-1; end>0; end--){
            for(int i=0; i<end; i++){
                if(array[i] > array[i+1])
                    swap(array, i, i+1);
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
