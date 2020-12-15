class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];

        for(int i=1; i<nums.length; i++) {
            int mx = max, mn = min, num = nums[i];
            max = Math.max(Math.max(mx * num, mn * num), num);
            min = Math.min(Math.min(mx * num, mn * num), num);

            ans = Math.max(max, ans);
        }
        return ans;
    }

}
