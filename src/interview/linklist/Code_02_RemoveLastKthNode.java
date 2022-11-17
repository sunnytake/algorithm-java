package interview.linklist;

/**
 * 题目：
 * 分别实现两个函数，一个可以删除单链表中倒数第K个节点，
 * 另一个可以删除双链表中倒数第K个节点。
 */
public class Code_02_RemoveLastKthNode {

    static class Node{
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeLastKthNode(Node head, int k){
        if(head == null || k < 1)
            return head;
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0)
            head = head.next;
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int k){
        if(head == null || k < 1)
            return head;
        DoubleNode cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0) {
            head = head.next;
            if(head != null)
                head.pre = null;
        }else if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if(cur.next != null)
                cur.next.pre = cur;
        }
        return head;
    }

}






















