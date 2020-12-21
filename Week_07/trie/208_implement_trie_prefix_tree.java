
class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

}


class Trie {

    /** Initialize your data structure here. */

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i< word.length(); i++) {
            char curr = word.charAt(i);
            if(!node.containKey(curr)) {
                node.put(curr, new TrieNode());
            }
            node = node.get(curr);
        }

        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char curr = word.charAt(i);
            if(!node.containKey(curr)) {
                return false;
            } else {
                node = node.get(curr);
            }
        }

        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            char curr = prefix.charAt(i);
            if(!node.containKey(curr)) {
                return false;
            } else {
                node = node.get(curr);
            }
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
