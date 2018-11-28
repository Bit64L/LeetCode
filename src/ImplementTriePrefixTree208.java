public class ImplementTriePrefixTree208 {
}
class TireNode{
    boolean isWord;
    TireNode[] links;
    public TireNode(){
        links = new TireNode[26];
    }
}
class Trie {

    private TireNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TireNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode node = root;
        for(int i=0;i<word.length();i++){
            char tmp = word.charAt(i);
            if(node.links[tmp-'a'] == null)
                node.links[tmp-'a'] = new TireNode();
            node = node.links[tmp-'a'];
        }
        node.isWord =true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode node = root;
        for(int i=0;i<word.length();i++){
            char tmp = word.charAt(i);
            if(node.links[tmp-'a'] == null) return false;
            node = node.links[tmp-'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for(int i=0;i<prefix.length();i++){
            char tmp = prefix.charAt(i);
            if(node.links[tmp-'a'] == null) return false;
            node = node.links[tmp-'a'];
        }
        return true;
    }
}