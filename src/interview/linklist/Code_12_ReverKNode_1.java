package interview.linklist;

import java.util.Stack;

/**
 * 题目：将单链表的每 K个节点之间逆序
 * 给定一个单链表的头节点 head，实现一个调整单链表的函数，使得每 K个节点之间逆如果最后不够 K个节点一组，则不调整最后几个节点。
 * 例如:
 * 链表:1->2->3->4->5->6->7->8->null，K=3。
 * 调整后为:3->2->1->6->5->4->7->8->null。其中7、8 不调整，因为不够一组。
 */
public class Code_12_ReverKNode_1 {

    static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }


    // 借助栈
    public static Node reverseKNodes1(Node head, int k){
        if(k < 2)
            return head;
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        Node next = null;
        Node pre = null;
        Node newHead = head;
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    public static Node resign1(Stack<Node> stack, Node left, Node right){
        Node cur = stack.pop();
        if(left != null)
            left.next = cur;
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

}
