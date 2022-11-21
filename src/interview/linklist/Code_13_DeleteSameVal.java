package interview.linklist;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：删除无序单链表中值重复出现的节点
 * 给定一个无序单链表的头节点 head，删除其中值重复出现的节点。
 * 例如:1->2->3->3->4->4->2->1->1->null，删除值重复的节点之后为1->2->3->4->null.
 * 请按以下要求实现两种方法。
 * 方法1:如果链表长度为N，时间复杂度达到 O(N)。
 * 方法2:额外空间复杂度为 O(1)。
 */
public class Code_13_DeleteSameVal {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // 借助哈希set实现。时间复杂度为O(N)，空间复杂度为O(N)
    public void deleteSameVal(Node head){
        if(head == null)
            return;
        HashSet<Integer> set = new HashSet<>();
        Node cur = head.next;
        Node pre = head;
        set.add(head.value);
        while(cur != null){
            if(set.contains(cur.value))
                pre.next = cur.next;
            else{
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    // 类似排序的过程，时间复杂度为O(N^2)，额外空间复杂度为O(1)
    public void deleteSameVal2(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            pre = cur;
            next = cur.next;
            while(next != null){
                if(cur.value == next.value)
                    pre.next = next.next;
                else
                    pre = next;
                next = next.next;
            }
            cur = cur.next;
        }
    }

}
