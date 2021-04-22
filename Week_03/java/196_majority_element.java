class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];

        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        if(low == high) return nums[low];
        else {
            int mid = (high - low) / 2 + low;
            int left = majorityElementRec(nums, low, mid);
            int right = majorityElementRec(nums, mid+1, high);

            if(left == right) return left;

            int leftCount = countInRange(nums, left, low, high);
            int rightCount = countInRange(nums, right, low, high);
            return leftCount > rightCount ? left : right;
        }
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
