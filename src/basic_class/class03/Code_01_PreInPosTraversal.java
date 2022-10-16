package basic_class.class03;

import java.util.Stack;

/**
 * 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式
 */
public class Code_01_PreInPosTraversal {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrderRecur(Node root){
        if(root == null)
            return;
        System.out.print(root.value + "\t");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void preOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        Node node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.value + "\t");
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null)
                stack.add(node.left);
        }
        System.out.println();
    }

    public static void inOrderRecur(Node root){
        if(root == null)
            return;
        inOrderRecur(root.left);
        System.out.print(root.value + "\t");
        inOrderRecur(root.right);
    }

    public static void inOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(node != null){
            stack.add(node);
            node = node.left;
        }

        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.value + "\t");
            node = node.right;
            while(node != null){
                stack.add(node);
                node = node.left;
            }
        }
        System.out.println();
    }

    public static void posOrderRecur(Node root){
        if(root ==  null)
            return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.value + "\t");
    }

    public static void posOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> reverseStack = new Stack<Node>();
        stack.add(root);
        Node node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            reverseStack.add(node);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        while(!reverseStack.isEmpty()){
            System.out.println(reverseStack.pop().value + "\t");
        }
    }

}
