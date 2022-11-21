package interview.linklist;

/**
 * 题目：单链表的选择排序
 * 给定一个无序单链表的头结点head，实现单链表的选择排序
 * 要求：额外空间复杂度为O(1)
 */
public class Code_16_ListSelectionSort {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listSelectionSort(Node head){
        if(head == null)
            return head;
        Node sortedHead = null;
        Node sortedLast = null;
        Node unSorted = head;
        while(unSorted != null){
            Node minNode = unSorted;
            Node minPre = null;
            Node minNext = minNode.next;
            Node cur = unSorted.next;
            Node pre = unSorted;
            while(cur != null){
                if(minNode.value > cur.value) {
                    minNode = cur;
                    minPre = pre;
                    minNext = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
            if(minPre != null){
                minPre.next = minNext;
            }else{
                unSorted = minNext;
            }
            minNode.next = null;
            if(sortedHead == null){
                sortedHead = minNode;
                sortedLast = minNode;
            }else{
                sortedLast.next = minNode;
            }
        }
        return sortedHead;
    }

}
