package interview.binarytree;

import java.util.HashMap;

/**
 * 题目：通过先序和中序数组生成后序数组
 * 已知一棵二叉树所有的节点值都不同，给定这棵树正确的先序和中序数组，不要重建整棵树，而是通过这两个数组直接生成正确的后序数组。
 */
public class Code_19_PosByPreMid_1 {

    public int[] getPosArray(int[] pre, int[] in){
        if(pre == null || in == null)
            return null;
        int length = pre.length;
        int[] pos = new int[length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<length; i++){
            map.put(in[i], i);
        }
        setPos(pre, 0, length-1, in, 0, length - 1, pos, length-1, map);
        return pos;
    }

    // 由右往左依次填好后序数组pos
    // posStart为后续数组pos该填的位置
    // 返回值为pos该填的下一个位置
    public static int setPos(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, int[] pos, int posStart, HashMap<Integer, Integer> map){
        if(preStart > preEnd)
            return posStart;
        pos[posStart--] = pre[preStart];
        int index = map.get(pre[preStart]);
        posStart = setPos(pre, preStart - inEnd + index + 1, preEnd, in, index+1, inEnd, pos, posStart, map);
        return setPos(pre, preStart+1, preStart+index-inStart, in, inStart, index-1, pos, posStart, map);
    }

}
