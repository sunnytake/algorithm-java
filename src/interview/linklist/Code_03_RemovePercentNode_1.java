package interview.linklist;

/**
 * 题目：
 * 1.给定链表的头节点head，实现删除链表的中间节点的函数。
 * 例如：
 * 1 不删除任何节点；
 * 1-＞2，删除节点1；
 * 1-＞2-＞3，删除节点2；
 * 1-＞2-＞3-＞4，删除节点2；
 * 1-＞2-＞3-＞4-＞5，删除节点3；
 *
 * 2.给定链表的头节点head、整数a和b，实现删除位于a/b处节点的函数。
 * 例如：
 * 链表：1-＞2-＞3-＞4-＞5，假设a/b的值为r。
 * 如果r等于0，不删除任何节点；
 * 如果r在区间（0，1/5]上，删除节点1；
 * 如果r在区间（1/5，2/5]上，删除节点2；
 * 如果r在区间（2/5，3/5]上，删除节点3；
 * 如果r在区间（3/5，4/5]上，删除节点4；
 * 如果r在区间（4/5，1]上，删除节点5；
 * 如果r大于1，不删除任何节点。
 */
public class Code_03_RemovePercentNode_1 {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node removeMidNode(Node head){
        if(head == null || head.next == null)
            return head;
        if(head.next.next == null)
            return head.next;
        Node faster = head.next.next;
        Node slower = head;
        while(faster.next != null && faster.next.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return head;
    }

    public Node removeNodeByRatio(Node head, int a, int b){
        if(a < 1 || a > b){
            return head;
        }
        int length = 0;
        Node cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        int n = (int)Math.ceil(((double) (a * length)) / (double) b);
        if(n == 1)
            return head.next;
        if(n > 1){
            cur = head;
            while(--n != 1)
                cur = cur.next;
            cur.next = cur.next.next;
        }
        return head;
    }

}
























