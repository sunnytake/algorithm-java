package interview.binarytree;

/**
 * 题目：找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * 给定一棵二叉树的头节点 head，已知所有节点的值都不一样，返回其中最大的且符合搜索二叉树条件的最大拓扑结构的大小。
 */
public class Code_06_BiggestSearchTreeTopo_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int bstTopoSize(Node root){
        if(root == null)
            return 0;
        int max = maxTopo(root, root);
        max = Math.max(bstTopoSize(root.left), max);
        max = Math.max(bstTopoSize(root.right), max);
        return max;
    }

    /**
     * 首先来看这样一个问题，以节点h为头的树中，在拓扑结构中也必须以h为头的情况下，怎么找到符合搜索二叉树条件的最大结构?
     * 这个问题有一种比较容易理解的解法，我们先考h的孩子节点，
     * 根据孩子节点的值从h开始按照二叉搜索的方式移动，如果最后能移动到同一个孩子节点上，
     * 说明这个孩子节点可以作为这个拓扑的一部分，并继续考查这个孩子节点的孩子节点，一直延伸下去。
     * @param root
     * @param node
     * @return
     */
    public static int maxTopo(Node root, Node node){
        if(root != null && node != null && isBSTNode(root, node, node.value))
            return maxTopo(root, node.left) + maxTopo(root, node.right) + 1;
        return 0;
    }

    public static boolean isBSTNode(Node root, Node node, int value){
        if(root == null)
            return false;
        if(root == node)
            return true;
        return isBSTNode(root.value > value ? root.left : root.right, node, value);
    }

}
