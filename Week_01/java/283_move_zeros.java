class Solution{
    public void moveZeroes(int[] nums){
        int pos = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, pos, i);
                pos ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int cache = nums[i];
        nums[i] = nums[j];
        nums[j] = cache;
    }
}
