class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;

        // dp[i][1]：第i天手上持股，dp[i][0]：第i天不持股
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }

        return dp[len-1][0];
    }

}
