package interview.binarytree;

import java.util.Stack;

/**
 * 题目：调整搜索二叉树中两个错误的节点
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回。
 * 已知二叉树中所有节点的值都不一样，
 * 给定二叉树的头节点 head，返回一个长度为2的二叉树节点类型的数组errs，errs[0]表示个错误节点，errs[1]表示另一个错误节点。
 * 进阶:
 * 如果在原问题中得到了这两个错误节点，我们当然可以通过交换两个节点的节点值的方式让整棵二叉树重新成为搜索二叉树。
 * 但现在要求你不能这么做，而是在结构上完全交换两个节点的位置，请实现调整的函数。
 */
public class Code_08_ModifyErrorNodes_1 {
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node[] findErrorNodes(Node root){
        Node[] errors = new Node[2];
        if(root == null)
            return errors;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node node = root;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if(pre != null && pre.value > node.value){
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = node;
                }
                pre = node;
                node = node.right;
            }
        }
        return errors;
    }
}
