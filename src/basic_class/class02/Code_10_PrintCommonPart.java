package basic_class.class02;

/**
 * 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class Code_10_PrintCommonPart {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommonPart(Node head1, Node head2){
        Node p1 = head1;
        Node p2 = head2;
        while(p1 != null && p2 != null){
            if(p1.value < p2.value)
                p1 = p1.next;
            else if(p1.value > p2.value)
                p2 = p2.next;
            else{
                System.out.print(p1.value + ", ");
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }

}
