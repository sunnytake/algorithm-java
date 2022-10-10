package basic_class.class01;

/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class Code_12_SmallSum {

    public static Integer smallSum(int[] array){
        if(array == null || array.length < 2)
            return 0;
        return mergeSort(array, 0, array.length-1);
    }

    public static Integer mergeSort(int[] array, int left, int right){
        if(left == right)
            return 0;
        int mid = (left + right) / 2;
        int leftSmallSum = mergeSort(array, left, mid);
        int rightSmallSum = mergeSort(array, mid+1, right);
        return leftSmallSum + rightSmallSum + merge(array, left, mid, right);
    }

    public static Integer merge(int[] array, int left, int mid, int right){
        int p1 = left;
        int p2 = mid+1;
        int index = 0;
        int[] newArray = new int[right - left + 1];
        int smallSum = 0;

        while(p1<=mid && p2<=right){
            if(array[p1] < array[p2]){
                smallSum += (right - p2 + 1) * array[p1];
                newArray[index++] = array[p1++];
            }else{
                newArray[index++] = array[p2++];
            }
        }
        while(p1<=mid)
            newArray[index++] = array[p1++];
        while(p2<=right)
            newArray[index++] = array[p2++];

        for(int i=0; i<newArray.length; i++)
            array[left+i] = newArray[i];
        return smallSum;
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,2,5};
        System.out.println(smallSum(array));
    }

}
