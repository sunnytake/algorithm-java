package basic_class.class03;

/**
 * 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 */
public class Code_08_CompleteTreeNodeNumber_1 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNum(Node root){
        if(root == null)
            return 0;
        return bs(root, 1, mostLeftLevel(root, 1));
    }

    public static int bs(Node root, int level, int height){
        if(level == height)
            return 1;
        if(mostLeftLevel(root.right, level+1) == height){
            return (1 << (height - level)) + bs(root.right, level+1, height);
        }else{
            return  (1 << (height - level - 1)) + bs(root.left, level+1, height);
        }
    }

    public static int mostLeftLevel(Node root, int level){
        while(root.left != null){
            level++;
            root = root.left;
        }
        return level;
    }

}
