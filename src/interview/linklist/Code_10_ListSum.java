package interview.linklist;

import java.util.Stack;

/**
 * 问题：两个单链表生成相加链表
 * 假设链表中每一个节点的值都在0~9之间，那么链表整体就可以代表一个整数。
 * 例如:9->3->7，可以代表整数937。
 * 给定两个这种链表的头节点 head1 和 head2，请生成代表两个整数相加值的结果链表
 * 例如:
 * 链表1为9->3->7，链表2为6->3，最后生成新的结果链表为 1->0->0->0。
 */
public class Code_10_ListSum {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 利用链表逆序求解
    public static Node listSum(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        int value1 = 0;
        int value2 = 0;
        int value = 0;
        int jinwei = 0;
        Node node = null;
        Node next = null;
        while(head1 != null || head2 != null){
            value1 = head1 != null ? head1.value : 0;
            value2 = head2 != null ? head2.value : 0;
            value = value1 + value2 + jinwei;
            node = new Node(value % 10);
            jinwei = value / 10;
            node.next = next;
            next = node;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        if(jinwei > 0){
            next = node;
            node = new Node(jinwei);
            node.next = next;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }

    public static Node reverseList(Node head){
        if(head == null || head.next == null)
            return head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 利用栈结构求解
    public static Node listSum2(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while(head1 != null){
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while(head2 != null){
            stack2.push(head2.value);
            head2 = head2.next;
        }
        int value1;
        int value2;
        int value;
        int jinwei = 0;
        Node node = null;
        Node next = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            value1 = stack1.isEmpty() ? 0 : stack1.pop();
            value2 = stack2.isEmpty() ? 0 : stack2.pop();
            value = value1 + value2 + jinwei;
            next = node;
            node = new Node(value % 10);
            node.next = next;
            jinwei = value / 10;
        }
        if(jinwei > 0){
            next = node;
            node = new Node(jinwei);
            node.next = next;
        }
        return node;
    }

}
