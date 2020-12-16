// Flag to indicate whether a house has been robbed
class Solution0 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[][] dp = new int[len][2];
        // dp[i][0]: house i has been robbed
        // dp[i][1]: house i hasn't been robbed
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i=1; i< len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

}


class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i< len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[len-1];
    }

}
