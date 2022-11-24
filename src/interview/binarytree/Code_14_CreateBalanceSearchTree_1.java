package interview.binarytree;

/**
 * 题目：通过有序数组生成平衡搜索二叉树
 * 给定一个有序数组sortArr，已知其中没有重复值，用这个有序数组生成一棵平衡搜索二叉树，并且该搜索二叉树中序遍历的结果与sortArr 一致。
 */
public class Code_14_CreateBalanceSearchTree_1 {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node createBST(int[] array){
        if(array == null || array.length < 1)
            return null;
        return generate(array, 0, array.length-1);
    }

    public static Node generate(int[] array, int left, int right){
        if(left < right)
            return null;
        int mid = (left + right) / 2;
        Node root = new Node(array[mid]);
        root.left = generate(array, left, mid-1);
        root.right = generate(array, mid+1, right);
        return root;
    }
}
