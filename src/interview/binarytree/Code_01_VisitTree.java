package interview.binarytree;

import java.util.Stack;

public class Code_01_VisitTree {

    static class Node{
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
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void preOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.value);
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null)
                stack.add(node.left);
        }
    }

    public static void inOrderRecur(Node root){
        if(root == null)
            return;
        inOrderRecur(root.left);
        System.out.println(root.value);
        inOrderRecur(root.right);
    }

    public static void inOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.value);
            node = node.right;
        }
    }

    public static void posOrderRecur(Node root){
        if(root == null)
            return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.println(root.value);
    }

    public static void posOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        stack.push(root);
        Node node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            helpStack.push(node);
            if(node.left != null)
                stack.add(node.right);
            if(node.right != null)
                stack.add(node.left);
        }
        while(!helpStack.isEmpty()){
            System.out.println(helpStack.pop().value);
        }
    }

}
