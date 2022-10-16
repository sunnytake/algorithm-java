package basic_class.class02;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如：
 * 1->2->1，返回true。1->2->2->1，返回true。
 * 15->6->15，返回true。 1->2->3，返回false。
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 */
public class Code_11_IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 利用栈：需要n个空间
    public static boolean isPalindromeList(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.add(cur);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            if(cur.value != stack.pop().value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    // 利用栈：需要n/2个空间
    public static boolean isPalindromeList2(Node head){
        if(head == null || head.next == null)
            return true;
        // 结束时right走到右半部分的第一个节点（无论节点总数是奇数还是偶数）
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next!=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(right != null){
            stack.add(right);
            right = right.next;
        }
        cur = head;
        while(!stack.isEmpty()){
            if(cur.value != stack.pop().value)
                return false;
            cur = cur.next;
        }
        return true;
    }

    // 将后半部分翻转
    public static boolean isPalindromeList3(Node head){
        if(head == null || head.next == null)
            return false;
        // 奇数时，n1走到中间节点；偶数时，n1走到前半部分的尾部
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }

        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        boolean res = false;
        Node firstNode = head;
        Node lastNode = n1;
        while(lastNode != null && firstNode != null){
            if(firstNode.value != lastNode.value) {
                res = false;
                break;
            }
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }

        Node lastPre = n1.next;
        n1.next = null;
        Node temp=null;
        while(lastPre != null){
            temp = lastPre.next;
            lastPre.next = n1;
            n1 = lastPre;
            lastPre = temp;
        }
        return res;
    }

}
