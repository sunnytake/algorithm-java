package interview.binarytree;

/**
 * 题目：二叉树节点间的最大距离问题
 * 从二叉树的节点 A 出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。
 * 要求：如果二叉树的节点数为N，时间复杂度为O(N)
 */
public class Code_17_NodeMaxDis_2 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Record{
        public int maxDis; // 当前树中的最大距离
        public int maxDisInTree; // 距离树最远的孩子的距离

        public Record(int maxDis, int maxDisInTree) {
            this.maxDis = maxDis;
            this.maxDisInTree = maxDisInTree;
        }
    }

    public static int maxDistance(Node root){
        return posOrder(root).maxDis;
    }

    public static Record posOrder(Node root){
        if(root == null)
            return new Record(0, 0);
        Record leftRecord = posOrder(root.left);
        Record rightRecord = posOrder(root.right);
        int maxDis = leftRecord.maxDisInTree + rightRecord.maxDisInTree +1;
        int maxDisInTree = Math.max(leftRecord.maxDisInTree, rightRecord.maxDisInTree) + 1;
        return new Record(maxDis, maxDisInTree);
    }

}
