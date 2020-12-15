class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int xlen = text1.length(),  ylen = text2.length();
        if(xlen == 0 || ylen == 0) return 0;

        int[][] dp = new int[xlen][ylen];

        boolean rightSkip = false, downSkip = false;
        for(int i=0; i<xlen; i++) {
            if(text1.charAt(i) != text2.charAt(0) && !downSkip) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
                downSkip = true;
            }
        }

        for(int j=0; j<ylen; j++) {
            if(text2.charAt(j) != text1.charAt(0) && !rightSkip) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
                rightSkip = true;
            }
        }

        for(int i=1; i<xlen; i++) {
            for(int j=1; j<ylen; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[xlen-1][ylen-1];

    }
}
