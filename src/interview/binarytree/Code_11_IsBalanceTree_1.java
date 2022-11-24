package interview.binarytree;

/**
 * 题目：判断二叉树是否为平衡二叉树
 * 平衡二叉树的性质为:
 * 要么是一棵空树，要么任何一个节点的左右子树高度差的绝对值不超过1。
 * 给定一棵二叉树的头节点 head，判断这棵二叉树是否为平衡二叉树。
 * 要求：如果二叉树的节点数为N，要求时间复杂度为O(N)
 */
public class Code_11_IsBalanceTree_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanceTree(Node root){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    public static int getHeight(Node root, int level, boolean[] res){
        if(root == null)
            return level;
        int leftHeight = getHeight(root.left, level+1, res);
        if(!res[0])
            return level;
        int rightHeight = getHeight(root.right, level+1, res);
        if(!res[0])
            return level;
        if(Math.abs(leftHeight - rightHeight) > 1)
            res[0] = false;
        return Math.max(leftHeight, rightHeight);
    }

}
