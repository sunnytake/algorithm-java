package interview.linklist;

/**
 * 题目：按照左右半区的方式重新组合单链表
 * 给定一个单链表的头部节点 head，链表长度为N，如果N为偶数，那么前N/2个节点算作左半区，后N/2 个节点算作右半区:
 * 如果N为奇数，那么前 N/2个节点算作左半区，后N/2+1 个节点算作右半区。
 * 左半区从左到右依次记为L1->L2->·”，右半区从左到右依次记为R1->R2->···，
 * 请将单链表调整成 L1->R1->L2->R2->···的形式。
 * 例如:
 * 1->null，调整为1->null。
 * 1->2->null，调整为1->2->null。
 * 1->2->3->null，调整为 1->2->3->null。
 * 1->2->3->4->null，调整为 1->3->2->4->null。
 * 1->2->3->4->5->null，调整为 1->3->2->4->5-null。
 * 1->2->3->4->5->6->null，调整为1->4->2->5->3->6->null。
 */
public class Code_20_MergeLeftRightList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void relocate(Node head){
        if(head == null || head.next == null)
            return;
        Node mid = head;
        Node right = head.next;
        while(right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    public static void mergeLR(Node left, Node right){
        Node next = null;
        while(left.next != null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }

}
