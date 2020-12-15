class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int xlen = obstacleGrid.length, ylen = obstacleGrid[0].length;

        int[][] dp = new int[xlen][ylen];

        // 做后一排从右往左，从下往上，如果遇到一块石头，剩下的格子都是0，否则标1
        boolean downRock = false, rightRock = false;

        for(int i=xlen-1; i>=0; i--)  {
            if(obstacleGrid[i][ylen-1] == 0 && !rightRock) {
                dp[i][ylen-1] = 1;
            } else {
                dp[i][ylen-1] = 0;
                rightRock = true;
            }
        }

        for(int j=ylen-1; j>=0; j--) {
            if(obstacleGrid[xlen-1][j] == 0 && !downRock) {
                dp[xlen-1][j] = 1;
            } else {
                dp[xlen-1][j] = 0;
                downRock = true;
            }

        }

        for(int i=xlen-2; i>=0; i--) {
            for(int j=ylen-2; j>=0; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }

        return dp[0] [0];
    }
}
