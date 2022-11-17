package interview.linklist;

/**
 * 题目：
 * 给定一个单向链表的头节点head，以及两个整数from和to，在单向链表上把第from个节点到第to个节点这一部分进行反转。
 * 例如：
 * 1-＞2-＞3-＞4-＞5-＞null,from=2,to=4
 * 调整结果为：1-＞4-＞3-＞2-＞5-＞null
 * 1-＞2-＞3-＞null,from=1,to=3
 * 调整结果为：3-＞2-＞1-＞null
 */
public class Code_05_ReversePartLinkList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reversePartLikList(Node head, int from, int to){
        if(head == null || head.next == null || from < 1 || from >= to)
            return head;
        int length = 0;

        Node cur = head;
        Node pre = null; // 翻转后的前一个
        Node last = null; // 翻转后的后一个
        while(cur != null){
            length++;
            if(length == from - 1)
                pre = cur;
            if(length == to + 1)
                last = cur;
            cur = cur.next;
        }

        if(to < length)
            return head;

        cur = pre == null ? head : pre.next;
        Node next = cur.next;
        cur.next = last;
        Node nextNext = null;
        while(cur.next != last){
            nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }

        if(pre != null){
            pre.next = cur;
            return head;
        }
        return cur;
    }

}














