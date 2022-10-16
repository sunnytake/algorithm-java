package basic_class.class02;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】
 * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整 数pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如：链表9->0->4->5->1，pivot=3。
 * 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
 * 总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部分为空），右部分都是大于3的节点即可。
 * 对某部分内部的节点顺序不做要求。
 *
 * 进阶：
 * 在原问题的要求之上再增加如下两个要求。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致。
 * 例如：链表9->0->4->5->1，pivot=3。调整后的链表是0->1->9->4->5。
 * 在满足原问题要求的同时，左部分节点从左到右为0、1。
 * 在原链表中也 是先出现0，后出现1；
 * 中间部分在本例中为空，不再讨论；
 * 右部分节点 从左到右为9、4、5。
 * 在原链表中也是先出现9，然后出现4，最后出现5。
 * 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */
public class Code_12_SmallerEqualBigger {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void swap(Node[] array, int i, int j){
        Node temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 基础问题：借助链表结点数组实现
    public static Node listPartition1(Node head, int pivot){
        if(head == null)
            return head;
        Node cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        Node[] nodeArray = new Node[length];
        cur = head;
        for(int i=0; i<length; i++){
            nodeArray[i] = cur;
            cur = cur.next;
        }

        int index = 0;
        int less = -1;
        int more = length;
        while(index < more){
            if(nodeArray[index].value < pivot){
                swap(nodeArray, index++, ++less);
            }else if(nodeArray[index].value > pivot){
                swap(nodeArray, index, --more);
            }else{
                index++;
            }
        }

        for(int i=1; i<length; i++){
            nodeArray[i-1].next = nodeArray[i];
        }
        nodeArray[length-1].next = null;
        return nodeArray[0];
    }

    // 进阶问题
    public static Node listPartition2(Node head, int pivot){
        Node lessHead = null;
        Node lessTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node moreHead = null;
        Node moreTail = null;

        Node cur = head;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = null;
            if(cur.value < pivot){
                if(lessHead == null){
                    lessHead = cur;
                }else{
                    lessTail.next = cur;
                }
                lessTail = cur;
            }else if(cur.value > pivot){
                if(moreHead == null){
                    moreHead = cur;
                }else{
                    moreTail.next = cur;
                }
                moreTail = cur;
            }else{
                if(equalHead == null){
                    equalHead = cur;
                }else{
                    equalTail.next = cur;
                }
                equalTail = cur;
            }
            cur = next;
        }

        if(lessTail != null){
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }
        if(equalTail != null){
            equalTail.next = moreHead;
        }

        if(lessHead != null){
            return lessHead;
        }else{
            if(equalHead != null)
                return equalHead;
            else
                return moreHead;
        }
    }

}
