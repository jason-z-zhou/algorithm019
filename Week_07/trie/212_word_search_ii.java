
class TrieNode {
    public TrieNode[] links;
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
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

    public boolean contains(char x, TrieNode node){
        if(node.links[x-'a']!=null)  return true;
        else return false;
    }

}

class Solution {
    Set<String> result = new HashSet<>();
    int[] dx = new int []{-1,1,0,0};
    int[] dy = new int []{0,0,-1,1};
    int xlen, ylen;

    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null) return null;

        Trie tree = new Trie();

        for(String word: words) {
            tree.insert(word);
        }

        ylen = board.length;
        xlen = board.length;

        for(int i=0; i<xlen; i++) {
            for(int j=0; j<ylen; j++) {
                char curr = board[i][j];
                if(!tree.contains(curr, tree.root)) continue;
                dfs(board,i,j,"", tree.root);
            }
        }

        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, int x, int y, String curWord, TrieNode root) {
        TrieNode node = root.links[board[x][y]-'a'];
        if(node == null) return;

        curWord += board[x][y];

        System.out.println(x + "," + y + ":" + curWord);
        if(node.isEnd()) {
            result.add(curWord);
            return;
        }

        char tmp = board[x][y];
        board[x][y] = '@';

        for(int k=0; k<4; k++) {
            int newX = x+dx[k];
            int newY = y+dy[k];
            if(newX>=0 && newX<xlen &&newY>=0 && newY<ylen && board[newX][newY] != '@') {
                dfs(board, newX, newY, curWord, node);
            }
        }

        board[x][y] = tmp;
    }
}
