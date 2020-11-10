class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for(int i=1; i<len; ) {
            if(nums[i] == nums[i-1]) {
                // 移动数组
                for(int j=i; j<len-1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
            } else {
                i++;
            }

        }
        return len;
    }
}
