
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int slow = 2, fast = 2;

        while(fast < n){
            if(nums[slow-2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;

    }
}


class Solution {
    public int removeDuplicates(int[] nums, int k) {
        int n = nums.length;
        if(n <= k) return n;

        int slow = k, fast = k;

        while(fast < n){
            if(nums[slow-k] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        return slow;

    }
}
