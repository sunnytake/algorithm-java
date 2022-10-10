package basic_class.class01;

/**
 * 逆序对问题
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
 * 对
 */
public class Code_13_ReverseTuple {

    public static void reverseTuple(int[] array){
        if(array == null || array.length < 2)
            return;
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right){
        if(left == right)
            return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right){
        int p1 = left;
        int p2 = mid+1;
        int index = 0;
        int[] newArray = new int[right-left+1];

        while(p1<=mid && p2<=right){
            if(array[p1] <= array[p2])
                newArray[index++] = array[p1++];
            else{
                for(int i=p1; i<=mid; i++)
                    System.out.println(array[i] + ":" + array[p2]);
                newArray[index++] = array[p2++];
            }
        }

        while(p1 <= mid)
            newArray[index++] = array[p1++];
        while(p2 <= right)
            newArray[index++] = array[p2++];

        for(int i=0; i< newArray.length; i++)
            array[left + i] = newArray[i];
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,2,5};
        reverseTuple(array);
    }

}
