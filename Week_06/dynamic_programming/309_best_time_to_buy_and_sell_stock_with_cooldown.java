class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if( i == 1) {
                dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
            } else {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            }
        }

        return dp[len-1][0];

    }

}
