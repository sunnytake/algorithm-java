package interview.binarytree;

/**
 * 题目：找到二叉树中的最大搜索二叉子树
 * 给定一棵二叉树的头节点 head，已知其中所有节点的值都不一样，找到含有节点最多的搜索二叉子树，并返回这棵子树的头节点。
 */
public class Code_05_BiggestSearchTree_2 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node biggestSearchTree(Node root){
        // 节点数，最小值，最大值
        int[] record = new int[3];
        return posOrder(root, record);
    }

    public Node posOrder(Node root, int[] record){
        if(root == null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = root.value;
        Node left = root.left;
        Node right = root.right;
        Node lBST = posOrder(root.left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        Node rBST = posOrder(root.right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);
        if(left == lBST && right == rBST && lMax < value && rMin > value){
            record[0] = lSize + rSize + 1;
            return root;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }

}
