package basic_class.class03;

/**
 * 在二叉树中找到一个节点的后继节点
 * 【题目】 现在有一种新的二叉树节点类型如下：
 * public class Node {
 * public int value;
 * public Node left;
 * public Node right;
 * public Node parent;
 * public Node(int data) {
 * this.value = data;
 * }
 * }
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向 自己的父节点，头节点的parent指向null。
 * 只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
 * 在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 */
public class Code_03_SuccessorNode {

    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node successorNode(Node node){
        if(node == null)
            return null;

        if(node.right != null){ // 有右子树
            node = node.right;
            while(node.left != null)
                node = node.left;
            return node;
        }else{ // 没有右子树
            // 一直到是父结点的左子结点，打印父结点
            while(node.parent != null && node == node.parent.right)
                node = node.parent;
            return node.parent;
        }
    }

}
