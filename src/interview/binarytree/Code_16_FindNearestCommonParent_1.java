package interview.binarytree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树的头节点 head，以及这棵树中的两个节点o1和o2，请返回o1和2的最近公共祖先节点。
 * 进阶:如果查询两个节点的最近公共祖先的操作十分频繁，想法让单条查询的查询时间减少。
 * 再进阶:给定二叉树的头节点 head，同时给定所有想要进行的查询。二叉树的节点数量为N，查询条数为M，请在时间复杂度为O(N+M)内返回所有查询的结果。
 */
public class Code_16_FindNearestCommonParent_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node commonParent(Node root, Node node1, Node node2){
        if(root == null || root == node1 || root == node2)
            return root;
        Node left = commonParent(root.left, node1, node2);
        Node right = commonParent(root.right, node1, node2);
        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    // 结构1：建立节点和父节点的哈希表
    class Record1{
        private HashMap<Node, Node> map;

        public Record1(Node root) {
            this.map = new HashMap<Node, Node>();
            if(root != null)
                map.put(root, null);
            this.setMap(root);
        }

        public void setMap(Node root){
            if(root == null)
                return;
            if(root.left != null)
                this.map.put(root.left, root);
            if(root.right != null)
                this.map.put(root.right, root);
            setMap(root.left);
            setMap(root.right);
        }

        // 结构一建立记录的过程时间复杂度为 O(N)、额外空间复杂度为 O(N)。查询操作时，时间复杂度为 O(h)，其中，h为二叉树的高度。
        public Node query(Node node1, Node node2){
            HashSet<Node> path = new HashSet<>();
            while(this.map.containsKey(node1)){
                path.add(node1);
                node1 = this.map.get(node1);
            }
            while(!path.contains(node2)){
                node2 = this.map.get(node2);
            }
            return node2;
        }
    }

    // 结构二:直接建立任意两个节点之间的最近公共祖先记录，便于以后查询时直接查。
    class Record2{
        private HashMap<Node, HashMap<Node, Node>> map;

        public Record2(Node root){
            this.map = new HashMap<Node, HashMap<Node, Node>>();
            this.initMap(root);
            this.setMap(root);
        }

        public void initMap(Node root){
            if(root == null)
                return;
            this.map.put(root, new HashMap<Node, Node>());
            initMap(root.left);
            initMap(root.right);
        }

        public void setMap(Node root){
            if(root == null)
                return;
            this.headRecord(root.left, root);
            this.headRecord(root.right, root);
            this.subRecord(root);
            this.setMap(root.left);
            this.setMap(root.right);
        }

        private void headRecord(Node node, Node root){
            if(node == null)
                return;
            map.get(node).put(root, root);
            this.headRecord(node.left, root);
            this.headRecord(node.right, root);
        }

        private void subRecord(Node root){
            if(root == null)
                return;
            this.preLeft(root.left, root.right, root);
            this.subRecord(root.left);
            this.subRecord(root.right);
        }

        private void preLeft(Node left, Node right, Node root){
            if(left == null)
                return;
            this.preRight(left, right, root);
            this.preLeft(left.left, right, root);
            this.preLeft(left.right, right, root);
        }

        private void preRight(Node left, Node right, Node root){
            if(right == null)
                return;
            map.get(left).put(right, root);
            preRight(left, right.left, root);
            preRight(left, right.right, root);
        }

        private Node query(Node node1, Node node2){
            if(node1 == node2)
                return node1;
            if(map.containsKey(node1))
                return map.get(node1).get(node2);
            if(map.containsKey(node2))
                return map.get(node2).get(node1);
            return null;
        }
    }

}
