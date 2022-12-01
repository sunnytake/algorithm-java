package interview.binarytree;

/**
 * 题目：判断t1树是否包含t2树全部的拓扑结构
 * 给定彼此独立的两棵树头节点分别为 t1 和2，判断1 是否包含2全部的拓扑结构
 */
public class Code_09_TreeContainOther_2 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean contains(Node root1, Node root2){
        return check(root1, root2) || contains(root1.left, root2) || contains(root1.right, root2);
    }

    public static boolean check(Node root1, Node root2){
        if(root2 == null)
            return true;
        if(root1 == null || root1.value != root2.value)
            return false;
        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }


}
