class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] tmp = new int[len];

        System.arraycopy(nums, 0, tmp, 0, len);

        for(int i=0; i<len; i++){
            int j = (i + k) % len;
            nums[j] = tmp[i];
        }

    }
}
