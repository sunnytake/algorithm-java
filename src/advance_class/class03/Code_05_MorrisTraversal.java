package advance_class.class03;

/**
 * morris遍历：即动态线索二叉树
 * morris遍历可以将非递归遍历中的空间复杂度降为O(1)。从而实现时间复杂度为O(N)，而空间复杂度为O(1)的精妙算法。
 * morris遍历利用的是树的叶节点左右孩子为空（树的大量空闲指针），实现空间开销的极限缩减。
 *
 * 实现原则：
 * 记作当前节点为cur。
 * 1.如果cur无左孩子，cur向右移动（cur=cur.right）
 * 2.如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
 *  1). 如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
 *  2). 如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
 *
 * 实质：建立一种机制，对于没有左子树的节点只到达一次，对于有左子树的节点会到达两次
 *
 */
public class Code_05_MorrisTraversal {

    public static class Node{
        public int data;
        public Node left;
        public Node right;
    }

    public static void morrisPre(Node root){
        if(root == null)
            return;
        Node cur = root;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.println(cur.data + " ");
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                System.out.println(cur.data + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    public static void morrisIn(Node root){
        if(root == null)
            return;
        Node cur = root;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            System.out.println(cur.data + " ");
            cur = cur.right;
        }
        System.out.println();
    }

}
