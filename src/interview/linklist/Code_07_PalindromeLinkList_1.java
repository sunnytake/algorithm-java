package interview.linklist;

import java.util.Stack;

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
public class Code_07_PalindromeLinkList_1 {

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
        // 结束时right所在位置就是右半部分第一个
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value)
                return false;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeLinkListPro(Node head){
        if(head == null || head.next == null)
            return true;
        Node node1 = head;
        Node node2 = head;
        // 结束时node1所在位置就是左边最后一个（偶数）/中间结点（奇数）
        while(node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        // 把右半部分对折
        node2 = node1.next;
        node1.next = null;
        Node next = null;
        while(node2 != null){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        Node left = head;
        Node right = node1;
        boolean res = true;
        while(left != null && right != null){
            if(left.value != right.value){
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        // 修改回指针
        Node pre = right.next;
        right.next = null;
        while(pre != null){
            next = pre.next;
            pre.next = right;
            right = pre;
            pre = next;
        }
        return res;
    }

}



























