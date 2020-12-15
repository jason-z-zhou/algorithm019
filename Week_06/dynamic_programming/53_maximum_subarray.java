class Solution {
    public int maxSubArray(int[] nums) {
        int pre =0 , max = nums[0];

        for(int num: nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }

        return max;
    }

}
