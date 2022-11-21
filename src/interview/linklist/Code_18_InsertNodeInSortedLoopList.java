package interview.linklist;

/**
 * 题目：向有序的环形单链表中插入新节点
 * 个环形单链表从头节点 head 开始不降序，同时由最后的节点指回头节点。
 * 给定这样一个环形单链表的头节点 head和一个整数num，请生成节点值为 num 的新节点，并插入到这个环形链表中，
 * 保证调整后的链表依然有序。
 */
public class Code_18_InsertNodeInSortedLoopList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node insertNode(Node head, int num){
        Node node = new Node(num);
        if(head == null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while(cur != head){
            if(pre.value <= num && cur.value >= num)
                break;
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }

}
