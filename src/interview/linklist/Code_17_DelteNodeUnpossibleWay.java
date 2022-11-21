package interview.linklist;

/**
 * 题目：一种怪异的节点删除方式
 * 链表节点值类型为int型，给定一个链表中的节点node，但不给定整个链表的头节点。
 * 如何在链表中删除node?请实现这个函数，并分析这么会出现哪些问题。
 * 要求:时间复杂度为 O(1)。
 *
 * 本题的思路很简单，举例就能说明具体的做法。
 * 例如，链表 1->2->3-null，只知道要删除节点2，而不知道头节点。那么只需把节点2的值变成节点3的值，然后在链表中删除节点3即可。
 * 这道题目出现的次数很多，这么做看起来非常方便，但其实是有很大问题的。
 * 问题一:
 * 这样的删除方式无法删除最后一个节点。
 * 问题二:这种删除方式在本质上根本就不是删除了 node 节点，而是把 node 节点的值改变，然后删除 node 的下一个节点，在实际的工程中可能会带来很大问题。
 */
public class Code_17_DelteNodeUnpossibleWay {

    static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void deleteNodeUnpossbleWay(Node node){
        if(node == null)
            return;
        Node next = node.next;
        if(next == null)
            throw new RuntimeException("can not remove last node.");
        node.value = next.value;
        node.next = next.next;
    }

}
