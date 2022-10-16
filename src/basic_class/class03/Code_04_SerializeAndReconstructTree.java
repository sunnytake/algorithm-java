package basic_class.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class Code_04_SerializeAndReconstructTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static String serialByPre(Node root){
        if(root == null)
            return "#!";
        String res = root.value + "!";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i=0; i<values.length; i++)
            queue.add(values[i]);
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#"))
            return null;
        Node root = new Node(Integer.parseInt(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }

    public static String serialByLevel(Node root){
        if(root == null)
            return "#!";
        String res = "";
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node == null){
                res += "#!";
            }else{
                res += node.value + "!";
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return res;
    }

    public static Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if(head != null)
            queue.add(head);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return head;
    }

    public static Node generateNodeByString(String val){
        if(val.equals("#"))
            return null;
        return new Node(Integer.parseInt(val));
    }

}
