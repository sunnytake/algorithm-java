package interview.string;

/**
 * 问题：判断字符数组中是否所有的字符都只出现过一次
 * 题目：给定一个字符类型数组chas[]，判断 chas中是否所有的字符都只出现过一次，请根据以下不同的两种要求实现两个函数。
 * 举例：chas=['a','b','c']，返回 true; chas=['1','2','1']，返回 false。
 * 要求：
 * 1.实现时间复杂度为 O(N)的方法。
 * 2.在保证额外空间复杂度为 O(1)的前提下，请实现时间复杂度尽量低的方法
 */
public class Code_08_CharOnce {

    public static boolean isUnique2(char[] chars){
        if(chars == null)
            return true;
        heapSort(chars);
        for(int i=1; i<chars.length; i++){
            if(chars[i] == chars[i-1])
                return false;
        }
        return true;
    }

    public static void heapSort(char[] chars){
        for(int i=0; i<chars.length; i++)
            heapInsert(chars, i);
        for(int i=chars.length-1; i>0; i--){
            swap(chars, 0, i);
            heapify(chars, 0, i);
        }
    }

    public static void heapify(char[] chars, int i, int size){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while(left < size){
            if(chars[left] > chars[i]){
                largest = left;
            }
            if(right < size && chars[right] > chars[largest])
                largest = right;
            if(largest != i)
                swap(chars, largest, i);
            else
                break;
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    // 新结点加入进来并向上调整为大根堆的过程
    public static void heapInsert(char[] chars, int i){
        int parent = 0;
        while(i != 0){
            parent = (i-1) / 2;
            if(chars[parent] < chars[i]){
                swap(chars, i, parent);
                i = parent;
            }else{
                break;
            }
        }
    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static boolean isUnique1(char[] chars){
        if(chars == null || chars.length == 0)
            return true;
        boolean[] map = new boolean[256];
        for(int i=0; i< chars.length; i++){
            if(map[chars[i]])
                return false;
            map[chars[i]] = true;
        }
        return true;
    }

}
