// Solution0: DFS -> over time
class Solution0 {
    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins.length == 0) return -1;

        // sort the array: from large to small
        Integer[] tmp = new Integer[coins.length];
        for(int i = 0; i<coins.length; i++) {
            tmp[i] = coins[i];
        }

        Arrays.sort(tmp, (a, b) -> (b-a));

        for(int i = 0; i<coins.length; i++) {
            coins[i] = tmp[i];
        }

        dfs(coins, amount, 0);


        if(result == Integer.MAX_VALUE) result =  -1;
        return result;
    }

    private void dfs(int[] coins, int amount, int count) {
        if(amount < 0 ) return ;
        if(amount == 0) {
            result = Math.min(result, count);
            return;
        }

        for(int coin : coins) {
            dfs(coins, amount - coin, count + 1);
        }
    }
}


//DP

class Solution {

    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins.length == 0) return -1;

        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i=0; i<=amount; i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ?  -1 : dp[amount];

    }

}
