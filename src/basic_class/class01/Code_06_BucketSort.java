package basic_class.class01;

/**
 * 桶排序-计数排序
 */
public class Code_06_BucketSort {

    public static void bucketSort(int[] array){
        if(array == null || array.length < 2)
            return;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            max = Math.max(max, array[i]);
        }

        int[] bucket = new int[max+1];
        for(int i=0; i<array.length; i++){
            bucket[array[i]]++;
        }

        int i=0;
        for(int j=0; j<bucket.length; j++){
            while(bucket[j]-- > 0){
                array[i++] = j;
            }
        }

    }

}
