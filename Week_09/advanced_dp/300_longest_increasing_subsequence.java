class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int max = 1;

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
