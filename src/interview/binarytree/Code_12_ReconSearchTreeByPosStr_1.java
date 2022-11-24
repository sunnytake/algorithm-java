package interview.binarytree;

/**
 * 题目：根据后序数组重建搜索二叉树
 * 给定一个整型数组 arr，已知其中没有重复值，判断 arr 是否可能是节点值类型为整型的搜索二叉树后序遍历的结果。
 * 进阶:如果整型数组 arr 中没有重复值，且已知是一棵搜索二叉树的后序遍历结果，通过数组arr 重构二叉树。
 */
public class Code_12_ReconSearchTreeByPosStr_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isPostArray(int[] array){
        if(array == null || array.length == 0)
            return false;
        return isPost(array, 0, array.length - 1);
    }

    public static boolean isPost(int[] array, int left, int right){
        if(left == right)
            return true;
        int lessLast = -1; // 小于end的最后一个元素下标
        int moreFirst = right; // 大于end的第一个元素下标
        for(int i=left; i<right; i++){
            if(array[i] < array[right])
                lessLast = i;
            else
                moreFirst = moreFirst == right ? i : moreFirst;
        }
        if(lessLast == -1 || moreFirst == right){
            return isPost(array, left, right-1);
        }
        if(lessLast != moreFirst - 1)
            return false;
        return isPost(array, left, lessLast) && isPost(array, moreFirst, right - 1);
    }

    public static Node postArrayToBST(int[] posArray){
        if(posArray == null)
            return null;
        return posToBST(posArray, 0 , posArray.length - 1);
    }

    public static Node posToBST(int[] posArray, int left, int right){
        if(left > right)
            return null;
        Node root = new Node(posArray[right]);
        int lessLast = -1;
        int moreFirst = right;
        for(int i=left; i<right; i++){
            if(posArray[i] < posArray[right])
                lessLast = i;
            else
                moreFirst = moreFirst == right ? i : moreFirst;
        }
        root.left = posToBST(posArray, left, lessLast);
        root.right = posToBST(posArray, moreFirst, right-1);
        return root;
    }

}
