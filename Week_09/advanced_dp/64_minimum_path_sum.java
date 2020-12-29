class Solution {
    public int minPathSum(int[][] grid) {
        int nr = grid.length, nc = grid[0].length;

        int[][] dp = new int[nr+1][nc+1];

        dp[0][0] = grid[0][0];

        for(int row=0; row<nr; row++) {
            for(int col=0; col<nc; col++) {
                if(row == 0 && col-1>=0) {
                    dp[row][col] = dp[row][col-1] + grid[row][col];
                }

                if(col == 0 && row-1>=0) {
                    dp[row][col] = dp[row-1][col] + grid[row][col];
                }
            }
        }

        for(int row=1; row<nr; row++) {
            for(int col=1; col<nc; col++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }

        return dp[nr-1][nc-1];
    }

}
