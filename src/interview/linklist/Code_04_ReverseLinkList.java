package interview.linklist;

/**
 * 题目：
 * 分别实现反转单向链表和反转双向链表的函数。
 */
public class Code_04_ReverseLinkList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkList(Node head){
        if(head == null || head.next == null)
            return head;
        Node pre = null;
        Node cur = head;
        Node next = cur.next;
        while(cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        return pre;
    }

    static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleLinkList(DoubleNode head){
        if(head == null || head.next == null)
            return head;
        DoubleNode pre = null;
        DoubleNode cur = head;
        DoubleNode next = head.next;
        while(cur != null){
            cur.pre = next;
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        return pre;
    }

}



















