package interview.linklist;

/**
 * 题目：两个单链表相交的一系列问题
 * 单链表可能有环，也可能无环。给定两个单链表的头节点 head1和 head2,这两个链表可能相交，也可能不相交。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点;
 * 如果不相交，返回null 即可。
 * 要求:如果链表 1的长度为 N，链表 2的长度为 M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到 O(1)。
 */
public class Code_11_ListIntersec {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersecNode(Node head1, Node head2){
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            // 无环链表的公共节点
            return getIntersecNodeWithNoLoop(head1, head2);
        }else if(loop1 != null && loop2 != null){
            return getIntersecNodeWihtBothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    public static Node getIntersecNodeWihtBothLoop(Node head1, Node head2, Node loop1, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0){
                cur1 = cur1.next;
                n--;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2)
                    return loop1;
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersecNodeWithNoLoop(Node head1, Node head2){
        if(head1 == null || head2 == null)
            return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            n--;
            cur2 = cur1.next;
        }
        if(cur1 != cur2)
            return null;
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while(n != 0){
            cur1 = cur1.next;
            n--;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 获取环入口节点
     * 如果一个链表没有环，那么遍历链表一定可以遇到链表的终点:如果链表有环，那么遍历链表就永远在环里转下去了。如何找到第一个入环节点，具体过程如下:
     * 1.设置一个慢指针 slow 和一个快指针 fast。在开始时，slow 和 fast 都指向链表的头节点head。然后slow 每次移动一步，fast 每次移动两步，在链表中遍历起来。
     * 2.如果链表无环，那么fast 指针在移动的过程中一定先遇到终点，一旦 fast 到达终点说明链表是没有环的，直接返回 null，表示该链表无环，当然也没有第一个入环的节点。
     * 3，如果链表有环，那么 fast 指针和 slow 指针一定会在环中的某个位置相遇，当fast和 slow 相遇时，fast 指针重新回到 head 的位置，slow 指针不动。接下来，fast 指针从每次移动两步改为每次移动一步，slow 指针依然每次移动一步，然后继续遍历。
     * 4.fast 指针和 slow 指针一定会再次相遇，并且在第一个入环的节点处相遇。证明略
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null)
                return null;
            slow = slow.next;
            fast = fast.next;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



}
