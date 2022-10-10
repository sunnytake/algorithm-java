package basic_class.class01;

/**
 * 插入排序：每次将无序部分的一个数插入到有序部分
 */
public class Code_01_InsertionSort {

    public static void InsertionSort(int[] array){
        if(array == null || array.length < 2)
            return;

        for(int i=1; i<array.length; i++){
            for(int j=i-1; j>=0 && array[j] > array[j+1]; j--){
                swap(array, j, i);
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
