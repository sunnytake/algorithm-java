package interview.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_13_IsSearchTreeOrFullTree_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 是否为完全二叉树
    public static boolean isFullTree(Node root){
        if(root == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.offer(root);
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;
            if((leaf && (left!=null || right!=null)) || (left == null && right != null))
                return false;
            if(left != null)
                queue.offer(left);
            if(right != null)
                queue.offer(right);
            else
                leaf = true;
        }
        return true;
    }

    // 中序便利，前小后大
    public static boolean isSearchTree(Node root){
        if(root == null)
            return true;
        Node pre = null;
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            if(pre != null && pre.value > node.value){
                return false;
            }else{
                pre = node;
            }
            node = node.right;
        }
        return true;
    }

}
