package basic_class.class01;


/**
 * 选择排序：每次从无序部分从左到右选出一个最小的，放在前面
 */
public class Code_02_SelectionSort {

    public static void selectionSort(int[] array){
        if(array == null || array.length < 2)
            return;

        for(int i=0; i<array.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<array.length; j++){
                minIndex = array[minIndex] < array[j] ? minIndex : j;
            }
            swap(array, i, minIndex);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
