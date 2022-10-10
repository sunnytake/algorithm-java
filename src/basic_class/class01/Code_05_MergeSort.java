package basic_class.class01;

/**
 * 归并排序：每次把两个小的有序序列合并为一个大一级的有序序列
 */
public class Code_05_MergeSort {

    public static void mergeSort(int[] array){
        if(array == null || array.length == 0)
            return;
        mergeSort(array, 0, array.length-1);
    }

    public static void mergeSort(int[] array, int left , int right){
        if(left == right)
            return;

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] newArray = new int[right - left + 1];
        int i = left;
        int j = mid+1;
        int index = 0;
        while(i<=mid && j<=right){
            if(array[i] <= array[j])
                newArray[index++] = array[i++];
            else
                newArray[index++] = array[j++];
        }
        while(i<=mid)
            newArray[index++] = array[i++];
        while(j<=right)
            newArray[index++] = array[j++];

        for(i=0; i< newArray.length; i++){
            array[left+i] = newArray[i];
        }

    }

}
