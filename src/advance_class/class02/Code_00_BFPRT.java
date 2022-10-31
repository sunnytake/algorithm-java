package advance_class.class02;

/**
 * 题目：在一个无序数组找到第K个最小的数。
 * 方法1：通过构建一个大根堆。将数据存入大根堆中。为什么是大根堆？当数据超过K个时，根据与大根堆的数据进行比较，然后判断是否有资格弹出堆顶元素，将自己放入大根堆中。
 * 方法2：快速排序中的partition过程。划分过程就是将随机挑一个数，然后将整个数组分成大于该数，等于该数，小于该数的三个部分，然后判断等于区域的左右端的下标是否包含K，如果不包含，则观察下标的大小，判断应该在大于区还是在小于区，以此作为继续递归，partition的过程，直至找到包含K的等于区域的区间。（如果打偏了，value值没选好，则可能进入一个大的区间进行递归。长期期望是O(N)）
 * arr数组的大小为N，我们需要返回其第K小的数。
 * 将数组逻辑概念上进行分组，没5个数为一组。
 * 每个小组找出中位数，并且生成一个新的中位数，加入新的数组中。
 * https://xinh79.github.io/2019/12/21/%E5%B7%A6%E7%A8%8B%E4%BA%91%E7%AE%97%E6%B3%95%E8%AE%B2%E8%A7%A3%E7%AC%94%E8%AE%B0-VII/
 */
public class Code_00_BFPRT {
    // O(N * logK)
    public static int[] getMinKNumsByHeap(int[] array, int k){
        if(k < 1 || k > array.length)
            return array;

        int[] kHeap = new int[k];
        for(int i=0; i<k; i++){
            heapInsert(kHeap, i, array[i]);
        }

        for(int i=k+1; i<array.length; i++){
            if(array[i] < kHeap[0]) {
                kHeap[0] = array[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void heapInsert(int[] array, int index, int value){
        int parentIndex = (index - 1) / 2;
        while(index > 0 && array[index] > array[parentIndex]){
            swap(array, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public static void heapify(int[] array, int index, int size){
        int left = 2*index + 1;
        int largest;
        while(left < size){
            largest = array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if(index == largest)
                break;
            swap(array, index, largest);
            index = largest;
            left = 2*index + 1;
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    // BFPRT O(N)
    public static int[] getMinNumsByBFPRT(int[] array, int k){
        if(k < 1 || k > array.length)
            return array;

        int minKth = getMinKthByBFPRT(array, k);
        int[] res = new int[k];
        int index = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] < minKth)
                res[index++] = array[i];
        }

        for(; index < res.length; index++){
            res[index] = minKth;
        }
        return res;
    }

    public static int getMinKthByBFPRT(int[] array, int k){
        int[] copyArr = copyArray(array);
        return select(copyArr, 0, copyArr.length - 1, k - 1);
    }

    public static int[] copyArray(int[] array){
        int[] copyArr = new int[array.length];
        for(int i=0; i<array.length; i++)
            copyArr[i] = array[i];
        return copyArr;
    }

    public static int select(int[] array, int begin, int end, int index){
        if(begin == end)
            return array[begin];
        int pivot = medianOfMedians(array, begin, end);
        int[] pivotRange = partition(array, begin, end, pivot);
        if(index >= pivotRange[0] && index <= pivotRange[1])
            return array[index];
        else if(index < pivotRange[0])
            return select(array, begin, pivotRange[0]-1, index);
        else
            return select(array, pivotRange[1] + 1, end, index);
    }

    public static int medianOfMedians(int[] array, int begin, int end){
        int num = end - begin + 1;
        int offset = num  % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for(int i=0; i<mArr.length; i++){
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(array, beginI, Math.min(end, endI));
        }
        return select(mArr, 0, mArr.length-1, mArr.length/2);
    }

    public static int getMedian(int[] array, int begin, int end){
        insertionSort(array, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return array[mid];
    }

    public static void insertionSort(int[] array, int begin, int end){
        if(begin == end)
            return;
        for(int i=begin+1; i<= end; i++){
            for(int j=i-1; j>=begin; j++){
                if(array[j] > array[j+1])
                    swap(array, j, j+1);
                else
                    break;
            }
        }
    }

    public static int[] partition(int[] array, int begin, int end, int pivot){
        int less = begin - 1;
        int more = end + 1;
        int cur = begin;
        while(cur < more){
            if(array[cur] < pivot){
                swap(array, cur++, ++less);
            }else if(array[cur] > pivot){
                swap(array, cur, --more);
            }else{
                cur++;
            }
        }
        return new int[]{less+1, more-1};
    }


    public static void main(String[] args) {
        System.out.println(-1/2);
    }



}
