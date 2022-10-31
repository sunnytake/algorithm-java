package advance_class.class02;

import java.util.LinkedList;

/**
 * 有一个整形数组arr 和一个大小为w 的窗口从数组的最左边滑到最右边，窗口每次向右滑动一个位置；
 * 如果数组长度是n，窗口大小是w，则一共产生n-w+1 个窗口，请实现一个函数，
 * 输入：整形arr数组，窗口大小w
 * 输出：一个长度为n-w+1 的数组res， res [i] 标识每种窗口状态下掉最大值。
 * 例：
 * 【3，4，6】7，9，2，4   最大值：6
 *   3【4，6，7】9，2，4   最大值：7
 * 3，4【6，7，9】2，4   最大值：9
 * 3，4，6【7，9，2】4   最大值：9
 * 3，4，6，7【9，2，4】   最大值：9
 */
public class Code_01_MaxWindow {

    public static int[] getMaxWindow(int[] array, int w){
        if(array == null || w < 0 || array.length < w)
            return null;
        LinkedList<Integer> maxIndexQueue = new LinkedList<>();
        int[] res = new int[array.length - w +1];
        int index = 0;
        for(int i=0; i<array.length; i++){
            if(!maxIndexQueue.isEmpty() && i - w == maxIndexQueue.peekFirst())
                maxIndexQueue.pollFirst();
            while (!maxIndexQueue.isEmpty() && array[maxIndexQueue.peekLast()] < array[i])
                maxIndexQueue.pollLast();
            maxIndexQueue.add(i);
            if(i >= w-1)
                res[index++] = array[maxIndexQueue.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 7, 9, 2, 4};
        int w = 3;
        int[] maxWindow = getMaxWindow(array, w);
        for(int val : maxWindow){
            System.out.print(val + " \t ");
        }
    }

}
