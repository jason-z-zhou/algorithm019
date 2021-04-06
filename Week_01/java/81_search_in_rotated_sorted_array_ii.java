
class Solution {
    public boolean search(int[] nums, int target) {

        int left=0, right = nums.length - 1;
        int mid = (left - right) / 2 + right;

        while(left < right) {
            mid = (left - right) / 2 + right;
            if (target == nums[mid] || target == nums[left] || target == nums[right]) return true;

            if(nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid] ) right = mid - 1;
                else left = mid + 1;
            } else if(nums[mid] < nums[left]) {
                if (target > nums[mid] && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                left++;
            }
        }

        return nums[mid] == target;

    }
}
