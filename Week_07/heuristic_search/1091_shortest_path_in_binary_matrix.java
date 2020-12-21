class Solution {
    private static int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int nr, nc;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
        Deque<int[]> queue = new LinkedList<>();

        nr = grid.length;
        nc = grid[0].length;

        queue.add(new int[]{0, 0});
        int path = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            for(int i=0; i<size; i++) {
                int[] data = queue.poll();
                int row = data[0], col = data[1];
                if(row == nr -1 && col == nc - 1) {
                    return path;
                }

                for(int[] direction: directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(inGrid(newRow, newCol) && grid[newRow][newCol] == 0){
                        queue.add(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 1;
                    }
                }
            }
            path ++ ;
        }

        return -1;
    }

    private boolean inGrid(int x, int y) {
        return x>=0 && x<nr && y>=0 && y<nc;
    }

}

//Heuristic Search



class Solution {
    private static int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int nr, nc;

    class Node implements Comparable<Node> {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int step) {
            this.row = row;
            this.col = col;
            int distance = Math.abs(nr - 1 - row) +  Math.abs(nc - 1 - col);
            this.distance = distance + step;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
        nr = grid.length;
        nc = grid[0].length;


        Queue<Node> queue = new PriorityQueue();

        queue.add(new Node(0, 0, 0));

        int step = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.row, col = node.col, distance = node.distance;
            if(row == nr -1 && col == nc - 1) {
                return step;
            }

            for(int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(inGrid(newRow, newCol) && grid[newRow][newCol] == 0){
                    queue.add(new Node(newRow, newCol, step + 1));
                    grid[newRow][newCol] = 1;
                }
            }
// How to keep track of steps
            step ++;
        }
        return -1;
    }

    private boolean inGrid(int x, int y) {
        return x>=0 && x<nr && y>=0 && y<nc;
    }

}
