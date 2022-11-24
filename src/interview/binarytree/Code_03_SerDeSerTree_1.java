package interview.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：二叉树的序列化和反序列化
 */
public class Code_03_SerDeSerTree_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 方法一:通过先序遍历实现序列化和反序列化。
     * 先介绍先序遍历下的序列化过程,首先假设序列化的结果字符串为str,
     * 初始时 str-"”先序遍历二叉树，如果遇到null节点，就在str的末尾加上“#!”,“#”表示这个节点为空节点值不存在，“!”表示一个值的结束
     * 如果遇到不为空的节点，假设节点值为3，就在str 的末尾加上“3!”。
     * @param root
     * @return
     */
    public static String serialByPre(Node root){
        if(root == null)
            return "#!";

        String res = root.value + "!";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    /**
     * 把结果字符串str 变成字符串类型的数组，记为 values，数组代表一棵二叉树先序遍历的节点顺序。例如，str-"1213!#!#!#!"，生成的 alues 为["12","3","#","#","#]，然后用values[0..4]按照先序遍历的顺序建立整棵树。
     * 1.遇到”12”，生成节点值为12的节点(head)，然后用 values[1..4]建立节点12的左子树
     * 2.遇到"3”，生成节点值为3的节点，它是节点12的左孩子，然后用values[2..4]建立节点3的左子树。
     * 3.遇到”#”，生成 null 节点，它是节点3的左孩子，该节点为 null，所以这个节点没有后续建立子树的过程。回到节点3后，用values[3..4]建立节点3的右子树。
     * 4.遇到"#"，生成 null 节点，它是节点3的右孩子，该节点为 null，所以这个节点没有后续建立子树的过程。回到节点3后，再回到节点1，用values[4]建立节点1的右子树。
     * 5.遇到“#"，生成 null 节点，它是节点 1的右孩子，该节点为 nul，所以这个节点没有后续建立子树的过程。整个过程结束。
     * @param preStr
     * @return
     */
    public static Node deSerialByPreString(String preStr){
        if(preStr == null || preStr.equals(""))
            return null;
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<values.length; i++)
            queue.add(values[i]);
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#"))
            return null;
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    /**
     * 通过层次遍历实现序列化和反序列化
     */
    public static String serialByLevel(Node root){
        if(root == null)
            return "#!";
        String res = "";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node == null)
                res += "#!";
            else {
                res += node.value + "!";
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static Node deserialByLevel(String levelStr){
        if(levelStr == null || levelStr.equals(""))
            return null;
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if(head != null)
            queue.offer(head);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return head;
    }

    public static Node generateNodeByString(String val){
        if(val.equals("#"))
            return null;
        return new Node(Integer.parseInt(val));
    }

}



















