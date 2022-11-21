package interview.linklist;

/**
 * 题目：将单向链表按某值划分成左边小，中间相等，右边大的形式
 * 给定一个单向链表的头节点 head，节点的值类型是整型，再给定一个整数 pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot 的节点，中间部分都是值等于pivot 的节点，右部分都是值大于 pivot 的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如:链表9->0->4->5->1，pivot=3。
 * 调整后链表可以是 1->0->4->9->5，也可以是 0->1->9->5->4。
 * 总之，满足左部分都是小于3的节点，中间部分都是等于3 的节点(本例中这个部分为空)，右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
 *
 * 进阶:
 * 在原问题的要求之上再增加如下两个要求
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致。
 * 例如:链表 9->0->4-5->1，pivot=3。调整后的链表是 0->1->9->4->5。
 */
public class Code_08_ListSplitPart {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listSplit(Node head, int pivot){
        Node less = null;
        Node same = null;
        Node more = null;
        while(head != null){
            if(head.value == pivot) {
                if (same == null)
                    same = head;
                else
                    same.next = head;
            }else if(head.value < pivot) {
                if (less == null)
                    less = head;
                else
                    less.next = head;
            }else {
                if (more == null)
                    more = head;
                else
                    more.next = head;
            }
            head = head.next;
        }
        Node newHead = less;
        if(newHead == null)
            newHead = same;
        else
            newHead.next = same;
        if(newHead == null)
            newHead = more;
        else
            newHead.next = more;
        return newHead;
    }

}


























