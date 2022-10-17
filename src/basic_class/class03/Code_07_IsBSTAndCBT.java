package basic_class.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.判断一棵树是否是搜索二叉树
 * 2.判断一棵树是否是完全二叉树
 */
public class Code_07_IsBSTAndCBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node root){
        if(root == null)
            return true;

        Node cur = root;
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;

        while(!stack.isEmpty() || cur != null){
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre == null || cur.value < pre.value){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }

    public static boolean isCBT(Node root){
        if(root == null)
            return true;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node node = null;
        Node left = null;
        Node right = null;
        boolean leaf = false; // 表示从此开始所有结点均为叶子结点
        while(!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;
            if((leaf && (left != null || right != null)) || (left == null && right != null))
                return false;
            if(left != null)
                queue.add(left);
            else
                leaf = true;
            if(right != null)
                queue.add(right);
            else{
                leaf = true;
            }
        }
        return true;
    }

}
