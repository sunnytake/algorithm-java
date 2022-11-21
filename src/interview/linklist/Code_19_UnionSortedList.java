package interview.linklist;

/**
 * 题目：合并两个有序的单链表
 * 给定两个有序单链表的头节点 head1 和 head2，请合并两个有序链表，合并后的链表依然有序，并返回合并后链表的头节点。
 * 例如:
 * 0->2->3->7->null
 * 1->3->5->7->9->null
 * 合并后的链表为:0->1->2->3->3->5->7->7->9->nul1
 */
public class Code_19_UnionSortedList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node unionSortedList(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        Node cur1 = null;
        Node cur2 = null;
        Node newHead = null;
        if(head1.value < head2.value){
            newHead = head1;
            cur1 = head1.next;
            cur2 = head2;
        }else{
            newHead = head2;
            cur1 = head1;
            cur2 = head2.next;
        }
        Node newTail = newHead;
        while(cur1 != null && cur2 != null){
            if(cur1.value <= cur2.value){
                newTail.next = cur1;
                newTail = cur1;
                cur1 = cur1.next;
            }else{
                newTail.next = cur2;
                newTail = cur2;
                cur2 = cur2.next;
            }
            newTail.next = null;
        }

        if(cur1 != null){
            newTail.next = cur1;
        }
        if(cur2 != null){
            newTail.next = cur2;
        }
        return newHead;
    }

}
