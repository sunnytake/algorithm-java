package interview.linklist;

/**
 * 题目：
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 */
public class Code_01_PrintCommonPart {

    static class Node{
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommonPart2(Node head1, Node head2) {
        while(head1 != null && head2 != null){
            if(head1.value < head2.value)
                head1 = head1.next;
            else if(head2.value < head1.value)
                head2 = head2.next;
            else{
                System.out.print(head1.value + "\t");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    // 有序意味着一定无环
    public static void printCommonPart1(Node head1, Node head2){
        int lengthDiff = 0;
        Node p1 = head1;
        while(p1 != null){
            lengthDiff++;
            p1 = p1.next;
        }
        Node p2 = head2;
        while(p2 != null){
            lengthDiff--;
            p2 = p2.next;
        }
        Node longer = lengthDiff > 0 ? head1 : head2;
        Node shorter = lengthDiff > 0 ? head2 : head1;
        lengthDiff = lengthDiff > 0 ? lengthDiff : -lengthDiff;
        while(lengthDiff > 0){
            lengthDiff--;
            longer = longer.next;
        }
        while(longer != null){
            System.out.print(longer.value + "\t");
        }
    }

}
