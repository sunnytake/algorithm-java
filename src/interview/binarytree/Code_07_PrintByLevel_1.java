package interview.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：二叉树的按层打印与ZigZag打印
 */
public class Code_07_PrintByLevel_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printByLevel(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = root;
        Node nLast = null;
        Node node = null;
        queue.offer(root);
        System.out.println("Level " + (level ++ ) + " : ");
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.value + " ");
            if(node.left != null){
                queue.offer(node.left);
                nLast = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nLast = node.right;
            }
            if(node == last && !queue.isEmpty()){
                System.out.println("\nLevel " + (level ++ ) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }

    public static void printByZigZag(Node root){
        if(root == null)
            return;
        Deque<Node> dq = new LinkedList<Node>();
        int level = 1;
        boolean left2Right = true;
        Node last = root;
        Node nLast = null;
        Node node = null;
        dq.offer(root);
        printLevelAndOrientation(level++, left2Right);
        while(!dq.isEmpty()){
            if(left2Right){
                node = dq.pollFirst();
                if(node.left != null){
                    nLast = nLast == null ? root.left : nLast;
                    dq.offerLast(root.left);
                }
                if(root.right != null){
                    nLast = nLast == null ? root.right : nLast;
                    dq.offerLast(root.right);
                }
            }else{
                node = dq.pollLast();
                if(node.right != null){
                    nLast = nLast == null ? root.right : nLast;
                    dq.offerFirst(root.right);
                }
                if(node.left != null){
                    nLast = nLast == null ? root.left : nLast;
                    dq.offerFirst(root.left);
                }
            }
            System.out.println(root.value + " ");
            if(root == last && !dq.isEmpty()){
                left2Right = !left2Right;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++, left2Right);
            }
        }
        System.out.println();
    }

    public static void printLevelAndOrientation(int level, boolean left2Right){
        System.out.print("Level " + level + " from ");
        System.out.print(left2Right ? "left to right：" : "right to left：");
    }

}






















