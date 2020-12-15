class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);

        int max1 = simpleRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int max2 = simpleRob(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(max1, max2);
    }

    private int simpleRob(int[] nums) {
        int len = nums.length;
        int max = nums[0];

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int i=2; i< len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[len-1];
    }

}
