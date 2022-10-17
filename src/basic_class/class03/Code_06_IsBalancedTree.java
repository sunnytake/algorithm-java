package basic_class.class03;


/**
 * 判断一棵二叉树是否是平衡二叉树
 */
public class Code_06_IsBalancedTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData{
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isBalanceTree1(Node root){
        return process(root).isB;
    }

    public static ReturnData process(Node root){
        if(root == null)
            return new ReturnData(true, 0);
        ReturnData leftReturnData = process(root.left);
        if(!leftReturnData.isB)
            return new ReturnData(false, 0);
        ReturnData rightReturnData = process(root.right);
        if(!rightReturnData.isB)
            return new ReturnData(false, 0);
        return new ReturnData(Math.abs(leftReturnData.h - rightReturnData.h) <= 1, Math.max(leftReturnData.h, rightReturnData.h)+1);
    }

    public static boolean isBalancedTree2(Node root){
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
