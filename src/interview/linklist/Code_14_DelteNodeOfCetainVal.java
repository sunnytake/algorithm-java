package interview.linklist;

public class Code_14_DelteNodeOfCetainVal {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteNodeOfCertainVal(Node head, int value){
        if(head == null)
            return head;
        Node pre = null;
        Node cur = head;
        Node next = null;
        Node newHead = null;
        while(cur != null){
            next = cur.next;
            if(value == cur.value && pre != null){
                pre.next = next;
            }else{
                pre = cur;
            }
            if(newHead == null && pre != null){
                newHead = pre;
            }
            cur = next;
        }
        return newHead;
    }
}
