package interview.linklist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：将搜索二叉树转换成双向链表
 * 对二叉树的节点来说，有本身的值域，有指向左孩子和右孩子的两个指针:
 * 对双向链表的节点来说，有本身的值域，有指向上一个节点和下一个节点的指针。
 * 在结构上，两种结构有相似性，现在有一棵搜索二叉树，请将其转换为一个有序的双向链表。
 */
public class Code_15_SearchTreeToDoubleList {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node searchTreeToDoubleList(Node root){
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(root, queue);
        Node head = queue.poll();
        Node pre = head;
        pre.left = null;
        pre.right = null;
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public static void inOrderToQueue(Node root, Queue<Node> queue){
        if(root == null)
            return;
        inOrderToQueue(root.left, queue);
        queue.add(root);
        inOrderToQueue(root.right, queue);
    }

}
