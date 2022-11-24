package interview.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：统计和生成所有不同的二叉树
 * 给定一个整数 N，如果 N<1，代表空树结构，否则代表中序遍历的结果为{1,2,3, ..., N}。请返回可能的二叉树结构有多少。
 */
public class Code_20_StatAndGenAllTree_1 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int numTrees(int n){
        if(n < 2)
            return 1;
        int[] num = new int[n+1];
        num[0] = 1;
        for(int i=1; i<n+1; i++)
            for(int j=i; j<i+1; j++){
                num[i] += num[j-1] * num[i-j];
        }
        return num[n];
    }


    public List<Node> generateTrees(int n){
        return generate(1, n);
    }

    public List<Node> generate(int start, int end){
        LinkedList<Node> res = new LinkedList<>();
        if(start > end)
            res.add(null);
        Node root = null;
        for(int i=start; i<end+1; i++){
            root = new Node(i);
            List<Node> lSubs = generate(start, i - 1);
            List<Node> rSubs = generate(i + 1, end);
            for(Node l : lSubs)
                for(Node r : rSubs){
                    root.left = l;
                    root.right = r;
                    res.add(cloneTree(root));
                }
        }
        return res;
    }

    public static Node cloneTree(Node root){
        if(root == null)
            return null;
        Node rootCopy = new Node(root.value);
        rootCopy.left = cloneTree(root.left);
        rootCopy.right = cloneTree(root.right);
        return rootCopy;
    }


}






















