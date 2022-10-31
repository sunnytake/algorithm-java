package advance_class.class01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：判断某棵树是否包含在另外一棵树中。
 * 将两个数序列化，如果字符串是其子串，则必定包含其中，反之亦然。当然为了避免出现诸如12_#_#_与2_#_#_出现误判，所以需要保证两个数值相等，或者个人觉得可以在前面也加一个_表示一个数据的开头与结尾。即_12__#__#_与_2_#_#_。
 * 如判断某棵树是否包含在另外一棵树中。转换为，判断字符串是否在另一个字符串中
 */
public class Code_03_TreeContain {

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static String serialByPre(Node root){
        if(root == null)
            return "#!";
        String res = "";
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        Node node = null;
        while(stack.size() > 0){
            node = stack.pop();
            if(node == null){
                res += "#!";
            }else{
                res += node.data + "!";
            }
            if(node != null) {
                stack.add(node.right);
                stack.add(node.left);
            }
        }
        return res;
    }

    public static int[] getNextArray(char[] chars){
        if(chars.length == 1)
            return new int[]{-1};
        int[] nexts = new int[chars.length];
        nexts[0] = -1;
        nexts[1] = 0;
        int cn = 0;
        int pos = 2;
        while(pos < chars.length){
            if(chars[pos-1] == chars[cn]){
                nexts[pos++] = ++cn;
            }else if(cn > 0){
                cn = nexts[cn];
            }else{
                nexts[pos] = 0;
            }
        }
        return nexts;
    }

    // KMP
    public static int getSubStringIndex(String s, String t){
        if(s == null || t == null || t.length() < 1 || s.length() < t.length())
            return -1;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        int[] nexts = getNextArray(t.toCharArray());
        while(sIndex < s.length() && tIndex < t.length()){
            if(sChars[sIndex] == tChars[tIndex]){
                sIndex++;
                tIndex++;
            }else if(nexts[tIndex] == -1){
                sIndex++;
            }else{
                tIndex = nexts[tIndex];
            }
        }
        return tIndex == tChars.length ? sIndex - tIndex : -1;
    }

    public static boolean isSubTree(Node root1, Node root2){
        String str1 = serialByPre(root1);
        String str2 = serialByPre(root2);
        return getSubStringIndex(str1, str2) != -1;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(serialByPre(t1));
    }

}
