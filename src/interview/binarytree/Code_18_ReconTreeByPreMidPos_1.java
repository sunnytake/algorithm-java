package interview.binarytree;

import java.util.HashMap;

/**
 * 题目：先序、中序和后序数组两两结合重构二叉树
 * 已知一棵二叉树的所有节点值都不同 给定这棵二叉树正确的先序、中序和后序数组。请分别用三个函数实现任意两种数组结合重构原来的二叉树，并返回重构二叉树的头节点。
 */
public class Code_18_ReconTreeByPreMidPos_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node preInToTree(int[] pre, int[] in){
        if(pre == null || in == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<in.length; i++)
            map.put(in[i], i);
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    public static Node preIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd)
            return null;
        Node root = new Node(pre[preStart]);
        int index = map.get(pre[preStart]);
        root.left = preIn(pre, preStart+1, preStart + index - inStart, in, inStart, index-1, map);
        root.right = preIn(pre, preStart + index - inStart + 1, preEnd, in, index+1, inEnd, map);
        return root;
    }

    public Node inPosToTree(int[] in, int[] pos){
        if(in == null || pos == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<in.length; i++)
            map.put(in[i], i);
        return inPos(in, 0, in.length-1, pos, 0, pos.length-1, map);
    }

    public Node inPos(int[] in, int inStart, int inEnd, int[] pos, int posStart, int posEnd, HashMap<Integer, Integer> map){
        if(inStart > inEnd)
            return null;
        Node root = new Node(pos[posEnd]);
        int index = map.get(pos[posEnd]);
        root.left = inPos(in, inStart, index-1, pos, posStart, posStart + index - inStart - 1, map);
        root.right = inPos(in, index+1, inEnd, pos, posStart + index - inStart, posEnd - 1, map);
        return root;
    }

    // 每个节点的孩子数都为0或2的二叉树才能先序与后序重构出来
    public Node prePosToTree(int[] pre, int[] pos){
        if(pre == null || pos == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<pos.length; i++){
            map.put(pos[i], i);
        }
        return prePos(pre, 0, pre.length-1, pos, 0, pos.length-1, map);
    }

    public Node prePos(int[] pre, int preStart, int preEnd, int[] pos, int posStart, int posEnd, HashMap<Integer, Integer> map){
        Node root = new Node(pos[posEnd--]);
        if(preStart == preEnd)
            return root;
        int index = map.get(pre[++preStart]);
        root.left = prePos(pre, preStart, preStart + index - posStart, pos, posStart, index, map);
        root.right = prePos(pre, preStart + index - posStart + 1, preEnd, pos, index+1, posEnd, map);
        return root;
    }

}


















