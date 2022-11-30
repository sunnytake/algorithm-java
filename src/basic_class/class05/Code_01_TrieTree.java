package basic_class.class05;


/**
 * 前缀树：根节点到某个结点的路径为经过该节点/以该节点为结尾的单词的树木
 */
public class Code_01_TrieTree {

    public static class TrieNode{
        public int path; // 经过该结点的字符串数量
        public int end; // 以该结点结尾的字符串数量
        public TrieNode[] nexts;

        public TrieNode(){
            this.path = 0;
            this.end = 0;
            this.nexts = new TrieNode[26]; // 26个英文字母
        }
    }

    public static class Trie{

        private TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word){
            if(word == null)
                return;
            root.path++;
            TrieNode node = this.root;
            char[] chars = word.toCharArray();
            int index = 0;
            for(int i=0; i<chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word){
            if(search(word) != 0) {
                char[] chars = word.toCharArray();
                int index = 0;
                TrieNode node = this.root;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word){
            if(word == null)
                return 0;
            char[] chars = word.toCharArray();
            TrieNode node = this.root;
            int index = 0;
            for(int i=0; i<chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre){
            if(pre == null)
                return 0;
            char[] chars = pre.toCharArray();
            TrieNode node = this.root;
            int index = 0;
            for(int i=0; i<chars.length; i++){
                index = chars[i] - 'a';
                if(node.nexts[index] == null)
                    return 0;
                node = node.nexts[index];
            }
            return node.path;
        }

    }

}
