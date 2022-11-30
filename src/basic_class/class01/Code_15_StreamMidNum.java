package basic_class.class01;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 最大堆和最小堆。我们注意到当数据保存到容器中时，可以分为两部分，左边最大的数小于右边最小的数。
 */
public class Code_15_StreamMidNum {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 小顶堆放大的元素(优先放)
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }); // 大顶堆放小的元素

    int count = 0;

    public void Insert(Integer num){
        count++;
        if(count%2==0){
            // 第偶数个，插入最小堆
            if(!maxHeap.isEmpty() && num < maxHeap.peek()){
                // 如果num小于最大堆，那么先插入最大堆
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }else{
            // 第奇数个，插入最大堆
            if(!minHeap.isEmpty() && num > minHeap.peek()){
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public Double GetMedian(){
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek() / 1.0;
        }else{
            return minHeap.peek() / 1.0;
        }
    }

}
