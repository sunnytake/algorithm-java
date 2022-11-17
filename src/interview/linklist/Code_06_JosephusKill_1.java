package interview.linklist;

/**
 * 题目；
 * 据说著名犹太历史学家Josephus有过以下故事：
 * 在罗马人占领乔塔帕特后，39个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，
 * 于是决定了一种自杀方式，41个人排成一个圆圈，由第1个人开始报数，报数到3的人就自杀，
 * 然后再由下一个人重新报1，报数到 3 的人再自杀，这样依次下去，
 * 直到剩下最后一个人时，那个人可以自由选择自己的命运。
 * 这就是著名的约瑟夫问题。现在请用单向环形链表描述该结构并呈现整个自杀过程。
 *
 * 输入：一个环形单向链表的头节点head和报数的值m。
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
 * 进阶问题：如果链表节点数为N，想在时间复杂度为O（N）时完成原问题的要求，该怎么实现？
 */
public class Code_06_JosephusKill_1 {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node josephusKill1(Node head, int m){
        if(head == null || head.next == null || m < 1)
            return head;
        // cur获取环尾结点，用于开始遍历
        Node cur = head;
        while(cur.next != head)
            cur = cur.next;
        Node next = head;

        int count = 0;
        while(next != cur) {
            if (++count == m) {
                cur.next = next.next;
                count = 0;
            } else {
                cur = cur.next;
            }
            next = cur.next;
        }
        return cur;
    }

    public static Node josephusKill2(Node head, int m){
        if(head == null || head.next == head || m < 1)
            return head;
        Node cur = head.next;
        int tmp = 1;
        while(cur != head){
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m);
        while(--tmp != 0)
            head = head.next;
        head.next = head;
        return head;
    }

    public static int getLive(int i, int m){
        if(i == 1)
            return 1;
        return (getLive(i-1, m) + m - 1) % i + 1;
    }

}
