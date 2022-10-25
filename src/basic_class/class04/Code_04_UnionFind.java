package basic_class.class04;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集结构
 */
public class Code_04_UnionFind {

    public static class Node{
        private int data;
        public Node(int data){
            this.data = data;
        }
    }

    public static class UnionSet{
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionSet(List<Node> nodes){
            this.fatherMap = new HashMap<Node, Node>();
            this.sizeMap = new HashMap<Node, Integer>();
            for(Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node){
            Node fathter = this.fatherMap.get(node);
            while(fathter != node)
                fathter = this.fatherMap.get(fathter);
            fatherMap.put(node, fathter);
            return fathter;
        }

        public void union(Node a, Node b){
            if(a == null || b == null)
                return;
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = this.sizeMap.get(aHead);
                int bSetSize = this.sizeMap.get(bHead);
                if(aSetSize <= bSetSize){
                    this.fatherMap.put(aHead, bHead);
                    this.sizeMap.put(bHead, aSetSize + bSetSize);
                }else{
                    this.fatherMap.put(bHead, aHead);
                    this.sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }

}
