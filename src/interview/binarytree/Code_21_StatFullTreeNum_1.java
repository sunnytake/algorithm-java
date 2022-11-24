package interview.binarytree;

public class Code_21_StatFullTreeNum_1 {

    static class Node{
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

    public static int mostLeftLevel(Node node, int level){
        while(node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static int bs(Node root, int level, int height){
        if(level == height)
            return 1;
        // 右子树最左节点能到达最后一层，说明左子树是满的
        if(mostLeftLevel(root.right, level + 1) == height)
            return 1 << (height - level) + bs(root.right, level+1, height);
        else
            // 右子树最左节点没到达最后一层，整棵树又是完全二叉树，所以右子树是满二叉树，层数为height - level - 1
            return (1 << (height - level - 1)) + bs(root.left, level+1, height);
    }

}
