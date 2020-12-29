class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int numOfStairs = cost.length;

        int[] dp = new int[numOfStairs+1];

        for(int i=0; i<= numOfStairs; i++) {
            if(i <= 1) {
                dp[i] = 0;
            } else {
                dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
            }
        }

        for(int i=0; i<=numOfStairs; i++) {
            System.out.println(dp[i]);
        }

        return dp[numOfStairs];
    }

}
