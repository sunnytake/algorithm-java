package interview.binarytree;

/**
 * 题目：打印二叉树的边界节点
 * 给定一棵二叉树的头节点 head，按照如下两种标准分别实现二叉树边界节点的逆时针打印。
 * 标准一:
 * 1.头节点为边界节点。
 * 2.叶节点为边界节点
 * 3。如果节点在其所在的层中是最左或最右的，那么也是边界节点。
 *
 * 标准二:
 * 1.头节点为边界节点
 * 2.叶节点为边界节点。
 * 3.树左边界延伸下去的路径为边界节点
 * 4.树右边界延伸下去的路径为边界节点。
 */
public class Code_02_PrintEdge_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 1，得到二叉树每一层上最左和最右的节点。
     * 2.从上到下打印所有层中的最左节点。
     * 3.先序遍历二叉树，打印那些不属于某一层最左或最右的节点，但同时又是叶节点的节点。
     * 4.从下到上打印所有层中的最右节点，但节点不能既是最左节点，又是最右节点。对
     * @param root
     */
    public static void printEdges1(Node root){
        if(root == null)
            return;
        int height = getHeight(root, 1);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(root, 1, edgeMap);
        // 打印左边界
        for(int i=0; i!= edgeMap.length; i++){
            System.out.println(edgeMap[i][0].value + " ");
        }
        // 打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(root, 1, edgeMap);
        // 打印右边界，但不是左边界的节点
        for(int i= edgeMap.length; i!=-1; i--){
            if(edgeMap[i][0] != edgeMap[i][1])
                System.out.println(edgeMap[i][1].value + " ");
        }
    }
    public static int getHeight(Node root, int height){
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left, height + 1), getHeight(root.right, height + 1));
    }

    public static void setEdgeMap(Node root, int height, Node[][] edgeMap){
        if(root == null)
            return;
        // 0取第一次赋值
        edgeMap[height-1][0] = edgeMap[height-1][0] == null ? root : edgeMap[height-1][0];
        // 1取最后一次赋值
        edgeMap[height-1][1] = root;
        setEdgeMap(root.left, height+1, edgeMap);
        setEdgeMap(root.right, height+1, edgeMap);
    }

    public static void printLeafNotInMap(Node root, int height, Node[][] map){
        if(root == null)
            return;
        if(root.left == null && root.right == null && root != map[height-1][0] && root != map[height-1][1])
            System.out.println(root.value + " ");
        printLeafNotInMap(root.left, height+1, map);
        printLeafNotInMap(root.right, height+1, map);
    }

    /**
     * 1.从头节点开始往下寻找，只要找到第一个既有左孩子，又有右孩子的节点，记为h,则进入步骤 2。在这个过程中，找过的节点都打印。
     * 2.h的左子树先进入步骤3的打印过程; h的右子树再进入步骤4的打印过程; 最后返回。
     * 3.打印左边界的延伸路径以及h左子树上所有的叶节点，具体请参看 printLeftEdge方法。
     * 4.打印右边界的延伸路径以及h右子树上所有的叶节点，具体请参看 printRightEdge方法。
     * @param root
     */
    public static void printEdges2(Node root) {
        if(root == null)
            return;
        System.out.println(root.value + " ");
        if(root.left != null && root.right != null){
            printLeftEdge(root.left, true);
            printRightEdge(root.right, true);
        }else{
            printEdges2(root.left != null ? root.left : root.right);
        }
        System.out.println();
    }

    public static void printLeftEdge(Node root, boolean print){
        if(root == null)
            return;
        if(print || (root.left == null && root.right == null))
            System.out.println(root.value + " ");
        printLeftEdge(root.left, print);
        printLeftEdge(root.right, print && root.left == null ? true : false);
    }

    public static void printRightEdge(Node root, boolean print){
        if(root == null)
            return;
        printRightEdge(root.left, print && root.right == null ? true : false);
        printRightEdge(root.right, print);
        if(print || (root.left == null && root.right == null))
            System.out.println(root.value + " ");
    }

}






























