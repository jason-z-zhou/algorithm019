// DFS
class Solution{
    private int xlen, ylen;
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null) return count;

        xlen = grid.length;
        ylen = grid[0].length;

        for(int i=0; i<xlen; i++) {
            for(int j=0; j<ylen; j++){
                if(grid[i][j] == '1') {
                    markDFS(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void markDFS(char[][] grid, int x, int y) {
        if(x<0 || x>=xlen || y<0 || y>=ylen || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = 0;
        markDFS(grid, x - 1, y);
        markDFS(grid, x + 1, y);
        markDFS(grid, x, y - 1);
        markDFS(grid, x, y + 1);
    }

}


// 并查集
class Solution{
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int nr = grid.length, nc = grid[0].length;

        int p[] = new int[nc * nr];

        for(int r=0; r<nr; r++) {
            for(int c=0; c<nc; c++) {
                p[r * nc + c] = r * nc + c;
            }
        }

        for(int r=0; r<nr; r++) {
            for(int c=0; c<nc; c++) {
                if(grid[r][c] == '1') {
                    if(r-1>=0 && grid[r-1][c] == '1') {
                        union(p, r*nc+c, (r-1)*nc+c);
                    }
                    if(r+1<nr && grid[r+1][c] == '1') {
                        union(p, r*nc+c, (r+1)*nc+c);
                    }
                    if(c-1>=0 && grid[r][c-1] == '1') {
                        union(p, r*nc+c, r*nc+c-1);
                    }
                    if(c+1<nc && grid[r][c+1] == '1') {
                        union(p, r*nc+c, r*nc+c+1);
                    }
                }
            }
        }

        Set<Integer> roots = new HashSet<>();

        for(int r=0; r < nr; r++) {
            for(int c=0; c < nc; c++) {
                if(grid[r][c] == '1') {
                    int root = parent(p, r * nc + c);
                    roots.add(root);
                }
            }
        }

        return roots.size();
    }

    private void union(int[] p, int i, int j) {
        int pI = parent(p, i);
        int pJ = parent(p, j);
        p[pI] = pJ;
    }

    private int parent(int[] p, int i) {
        int root = i;
        while(p[root] != root) {
            root = p[root];
        }

        while(p[i] != i) {
            int x = i;
            i = p[i];
            p[x] = root;
        }

        return root;
    }

}
