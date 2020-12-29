class Solution {
    public int minDistance(String word1, String word2) {
        int nr = word1.length(), nc= word2.length();
        int[][] dp = new int[nr+1][nc+1];

        for(int row=0; row <= nr; row++) {
            dp[row][0] = row;
        }

        for(int col=0; col <= nc; col++) {
            dp[0][col] = col;
        }

        for(int row=1; row<=nr; row++) {
            for(int col=1; col<=nc; col++) {
                int left = dp[row][col-1] + 1;
                int down = dp[row-1][col] + 1;
                int leftDown = dp[row - 1][col - 1];
                if (word1.charAt(row - 1) != word2.charAt(col - 1)) {
                    leftDown += 1;
                }
                dp[row][col] = Math.min(Math.min(left, down), leftDown) ;
            }
        }

        return dp[nr][nc];
    }

}
