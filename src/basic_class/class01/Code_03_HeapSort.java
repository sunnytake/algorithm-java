package basic_class.class01;

/**
 * 堆排序-大顶堆
 */
public class Code_03_HeapSort {

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void heapSort(int[] array){
        if(array == null || array.length < 2)
            return;

        for(int i=0; i<array.length; i++)
            heapInsert(array, i);

        int size = array.length;
        swap(array, 0, --size);
        while(size > 0){
            heapify(array, 0, size);
            swap(array, 0, --size);
        }
    }

    public static void heapInsert(int[] array, int index){
        while(array[index] > array[(index-1)/2]){
            swap(array, index, (index-1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] array, int index, int heapSize){
        int leftChild = 2*index+1;
        while(leftChild < heapSize){
            int largest = leftChild + 1 < heapSize && array[leftChild + 1] > array[leftChild] ? leftChild + 1 : leftChild;
            largest = array[largest] > array[index] ? largest : index;
            if(index == largest)
                break;
            swap(array, index, largest);
            index = largest;
            leftChild = 2*index+1;
        }
    }

}
