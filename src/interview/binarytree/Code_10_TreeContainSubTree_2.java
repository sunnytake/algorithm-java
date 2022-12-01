package interview.binarytree;

/**
 * 题目：判断t1树中是否有与t2树拓扑结构完全相同的子树
 * 给定彼此独立的两棵树头节点分别为 t1 和t2，判断1 中是子树否有与2 树拓扑结构完全相同的。
 */
public class Code_10_TreeContainSubTree_2 {

    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // 时间复杂度O(N*M)
    public static boolean isSubTree1(Node root1, Node root2){
        return check(root1, root2) || isSubTree1(root1.left, root2) || isSubTree1(root1.right, root2);
    }

    public static boolean check(Node root1, Node root2){
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        if(root1 == null && root2 == null)
            return true;
        if(root1.value == root2.value)
            return check(root1.left, root2.left) && check(root1.right, root2.right);
        return false;
    }

    // 时间复杂度O(N+M)的方法，把root1和root2按照现需便利序列化，然后判断一个串是否是另一个串的子串
    public static boolean isSubTree(Node root1, Node root2){
        String t1Str = serialByPre(root1);
        String t2Str = serialByPre(root2);
        return getIndexOf(t1Str, t2Str) != -1;
    }

    public static String serialByPre(Node root){
        if(root == null)
            return "#!";
        String res = root.value + "!";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    // KMP
    public static int getIndexOf(String str, String match){
        if(str == null || match == null || match.length() < 1 || str.length() < match.length())
            return -1;
        char[] strChars = str.toCharArray();
        char[] matchChars = match.toCharArray();
        int strIndex = 0;
        int matchIndex = 0;
        int[] next = getNextArray(matchChars);
        while(strIndex < strChars.length && matchIndex < matchChars.length){
            if(strChars[strIndex] == matchChars[matchIndex]){
                strIndex++;
                matchIndex++;
            }else if(next[matchIndex] == -1){
                strIndex++;
            }else{
                matchIndex = next[matchIndex];
            }
        }
        return matchIndex == matchChars.length ? strIndex - matchIndex : -1;
    }

    public static int[] getNextArray(char[] chars){
        if(chars.length == 1)
            return new int[]{-1};
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cur = 0;
        while(pos < next.length){
            if(chars[pos-1] == chars[cur]){
                next[pos++] = ++cur;
            }else if(cur > 0){
                cur = next[cur];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }

}
