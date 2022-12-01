package interview.binarytree;

import java.util.HashMap;

/**
 * 题目：在二叉树中找到累加和为指定值的最长路径长度
 * 给定一棵二叉树的头节点 head 和一个32位整数sum，二叉树节点值类型为整型，求累加和为 sum 的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所形成的节点链。
 */
public class Code_04_CertainValueLongestPath_2 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int getMaxLength(Node root, int sum){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 0);
        return preOrder(root, sum, 0, 1, 0, sumMap);
    }

    public int preOrder(Node root, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap){
        if(root == null)
            return maxLen;
        int curSum = preSum + root.value;
        if(!sumMap.containsKey(curSum))
            sumMap.put(curSum, level);
        if(sumMap.containsKey(curSum - sum)){
            maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
        }
        maxLen = preOrder(root.left, sum, curSum, level+1, maxLen, sumMap);
        maxLen = preOrder(root.right, sum, curSum, level+1, maxLen, sumMap);
        if(level == sumMap.get(curSum))
            sumMap.remove(curSum);
        return maxLen;
    }

    public static void main(String[] args) {
        Node node1 = new Node(-3);
        Node node2 = new Node(3);
        Node node3 = new Node(-9);
        Node node4 = new Node(1);
        Node node5 = new Node(0);
        Node node6 = new Node(2);
        Node node7 = new Node(1);
        Node node8 = new Node(1);
        Node node9 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
    }

}
