// Store surrouding land with queue
class Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null) return count;

        int xlen = grid.length;
        int ylen = grid[0].length;

        for(int i=0; i<xlen; i++) {
            for(int j=0; j<ylen; j++){
                Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
                if(grid[i][j] == '1') {
                    count ++ ;
                    grid[i][j] = '?';
                    queue.add(new Pair(i, j));
                    while(!queue.isEmpty()) {
                        Pair<Integer, Integer> current = queue.poll();
                        int x = current.getKey(), y= current.getValue();
                        if(x - 1 >= 0 && grid[x-1][y] == '1') {
                            queue.add(new Pair(x-1, y));
                            grid[x-1][y] = '?';
                        }

                        if(x + 1 < xlen && grid[x+1][y] == '1') {
                            queue.add(new Pair(x+1, y));
                            grid[x+1][y] = '?';
                        }

                        if(y - 1 >= 0 && grid[x][y-1] == '1') {
                            queue.add(new Pair(x, y-1));
                            grid[x][y-1] = '?';
                        }

                        if(y + 1 < ylen && grid[x][y+1] == '1') {
                            queue.add(new Pair(x, y+1));
                            grid[x][y+1] = '?';
                        }
                    }
                }
            }
        }

        return count;
    }
}

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
                    dfsMark(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfsMark(char[][] grid, int x, int y) {
        if(x<0 || x>=xlen || y<0 || y>=ylen || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = 0;
        dfsMark(grid, x - 1, y);
        dfsMark(grid, x + 1, y);
        dfsMark(grid, x, y - 1);
        dfsMark(grid, x, y + 1);
    }

}
