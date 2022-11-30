package basic_class.class01;

/**
 * 随机快速排序
 */
public class Code_04_QuickSort {

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void quickSort(int[] array){
        if(array == null || array.length < 2)
            return;
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int left, int right){
        if(left < right){
            swap(array, right, left + (int)(Math.random() * (right - left + 1)));
            int[] p = partition(array, left, right);
            quickSort(array, left, p[0]-1);
            quickSort(array, p[1]+1, right);
        }
    }

    public static int[] partition(int[] array, int left, int right){
        int less = left - 1;
        int more = right;
        int cur = left;
        while(cur < more){
            if(array[cur] < array[right]){
                swap(array, ++less, cur++);
            }else if(array[cur] > array[right]){
                swap(array, --more, cur);
            }else{
                cur++;
            }
        }
        swap(array, more, right);
        return new int[] {less+1, more};
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 7, 2, 5, 8};
        quickSort(array);
        for(int value : array)
            System.out.print(value + "\t");
    }

}
