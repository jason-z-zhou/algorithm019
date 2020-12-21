class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 ) return;
        int nr = board.length, nc = board[0].length;
        int[] p = new int[nr * nc + 1];

        for(int r=0; r<nr; r++) {
            for(int c=0; c<nc; c++) {
                p[r * nc + c] = r * nc + c;
            }
        }

        int dummy = nr * nc;
        p[dummy] = dummy;

        for(int r=0; r<nr; r++) {
            for(int c=0; c<nc; c++) {
                if(board[r][c] == 'O') {
                    // Handle border
                    if(r == 0 || c == 0 || r == nr-1 || c == nc-1) {
                        union(p, r*nc+c, dummy);
                    }
                    if(r-1>=0 && board[r-1][c] == 'O') {
                        union(p, r*nc+c, (r-1)*nc+c);
                    }
                    if(r+1<nr && board[r+1][c] == 'O') {
                        union(p, r*nc+c, (r+1)*nc+c);
                    }
                    if(c-1>=0 && board[r][c-1] == 'O') {
                        union(p, r*nc+c, r*nc+c-1);
                    }
                    if(c+1<nc && board[r][c+1] == 'O') {
                        union(p, r*nc+c, r*nc+c+1);
                    }
                }
            }
        }

        for(int r=0; r<nr; r++) {
            for(int c=0; c<nc; c++) {
                if(board[r][c] == 'O' && parent(p, r*nc + c) != dummy) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    public int parent(int[] p, int i) {
        int root = i;
        while(p[root] != root) {
            root = p[root];
        }
        while(p[i] != i) {
            int prev = i;
            i = p[i];
            p[prev] = root;
        }

        return root;
    }

    public void union(int[] p, int i, int j) {
        int pI = parent(p, i);
        int pJ = parent(p, j);
        if(pI >= pJ) p[pJ] = pI;
        else p[pI] = pJ;
    }
}
