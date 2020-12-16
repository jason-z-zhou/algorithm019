class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        // dp[i][0]: 第i天不持股，已经进行了0次交易
        // dp[i][1]: 第i天持股，已经进行了1次交易
        // dp[i][2]: 第i天不持股，已经进行了2次交易
        // dp[i][3]: 第i天持股，已经进行了3次交易
        // dp[i][4]: 第i天不持股，已经进行了4次交易

        int len = prices.length;

        int[][] dp =  new int[len][5];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 初始化第一天的数组，没有想到更好的办法
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for(int i=1; i<len; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        for(int i=0; i<len; i++) {
            System.out.println(dp[i][0] + "," + dp[i][1] + "," + dp[i][2] + "," + dp[i][3] + "," + dp[i][4]);
        }


        return Math.max(Math.max(dp[len-1][0], dp[len-1][2]), dp[len-1][4]);
    }

}
