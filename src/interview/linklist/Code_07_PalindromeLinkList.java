package interview.linklist;

/**
 * 题目：
 * 给定一个链表的头节点head，请判断该链表是否为回文结构
 * 例如；
 * 1->2->1，返回true。
 * 1->2->2->1，返回true
 * 15->6->15，返回true
 * 1->2->3，返回false
 * 进阶：
 * 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)
 */
public class Code_07_PalindromeLinkList {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindromeLinkList(Node head){
        if(head == null || head.next == null)
            return true;
        // 添加'#'结点，使得整个
        Node newHead = new Node('#');
        newHead.next = head;
        Node cur = head;
        Node next = cur.next;
        while(cur.next != null){
            Node insertNode = new Node('#');
            cur.next = insertNode;
            cur = next;
            next = cur.next;
        }
        cur.next = new Node('#');


    }

}
