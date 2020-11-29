
// Solution 1: backtracking : time complexity is not ideal
class Solution1 {
    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins.length == 0) return -1;

        // Larger coin comes first
        sort(coins);

        dfs(coins, amount, 0);

        if(result == Integer.MAX_VALUE) result =  -1;
        return result;
    }

    private void sort(int[] coins) {
        Integer[] tmp = new Integer[coins.length];
        for(int i = 0; i<coins.length; i++) {
            tmp[i] = coins[i];
        }

        Arrays.sort(tmp, (a, b) -> (b-a));

        for(int i = 0; i<coins.length; i++) {
            coins[i] = tmp[i];
        }
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
