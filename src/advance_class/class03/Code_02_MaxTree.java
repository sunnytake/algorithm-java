package advance_class.class03;

import java.util.HashMap;
import java.util.Stack;

/**
 * 定义二叉树如下：
 *
 * public class Node{
 *     public int value;
 *     public Node left;
 *     public Node right;
 *     public Node(int data){
 *         this.value=data;
 *     }
 * }
 * 一个数组的MaxTree定义如下：
 * ◆ 数组必须没有重复元素
 * ◆ MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点
 * ◆ 包括MaxTree树在内且在其中的每一颗子树上，值最大的节点都是树的头。
 * 给定一个没有重复元素arr，写出生成这个数组的MaxTree函数，要求如果数组长度为N，则时间复杂度为O(N)，额外空间复杂度为O(N)。
 *
 * 解法一：建出大根堆再重连成完全二叉树，o(n)
 * 解法二：单调栈
 * 1、左右都没比他大的节点就是头节点
 * 2、对于有左右其中一边的，这个数就串在有的底下，3在4底下
 * 3、对于左右都有的，挂在左右中较小的数下，2在3底下
 */
public class Code_02_MaxTree {

    //二叉树结点的定义如下
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        //结点的初始化
        public Node(int data) {
            this.value = data;
        }
    }


    public static Node getMaxTree(int[] array){
        Node[] nodeArray = new Node[array.length];
        for(int i=0; i<array.length; i++)
            nodeArray[i] = new Node(array[i]);

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> leftBigMap = new HashMap<>();
        HashMap<Node, Node> rightBigMap = new HashMap<>();
        for(int i=0; i<nodeArray.length; i++){
            while(!stack.isEmpty() && nodeArray[i].value > stack.peek().value){
                popStackSetMap(stack, leftBigMap, rightBigMap, nodeArray[i]);
            }
            stack.add(nodeArray[i]);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack, leftBigMap, rightBigMap, null);
        }

        Node head = null;
        for(int i=0; i < nodeArray.length; i++){
            Node cur = nodeArray[i];
            Node left = leftBigMap.get(cur);
            Node right = rightBigMap.get(cur);
            if(left == null && right == null)
                head = cur;
            else if(left == null){
                if(right.left == null)
                    right.left = cur;
                else
                    right.right = cur;
            }else if(right == null){
                if(left.left == null)
                    left.left = cur;
                else
                    left.right = cur;
            }else{
                Node parent = left.value < right.value ? left : right;
                if(parent.left == null)
                    parent.left = cur;
                else
                    parent.right = cur;
            }
        }
        return head;
    }

    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> leftBigMap, HashMap<Node, Node> rightBigMap, Node node){
        Node popNode = stack.pop();
        if(stack.isEmpty()){
            leftBigMap.put(popNode, null);
        }else{
            leftBigMap.put(popNode, stack.peek());
        }
        rightBigMap.put(popNode, node);
    }

    //二叉树的先序遍历
    public static void printPreOrder(Node head) {
        if (head == null) { return; }
        System.out.print(head.value + " ");
        printPreOrder(head.left);  //递归调用遍历二叉树
        printPreOrder(head.right);
    }

    //二叉树的中序遍历
    public static void printInOrder(Node head) {
        if (head == null) { return; }
        printInOrder(head.left);
        System.out.print(head.value + " ");
        printInOrder(head.right);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        Node head = getMaxTree(arr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);
    }

}
