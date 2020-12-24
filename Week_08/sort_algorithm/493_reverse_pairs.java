// Brutal force
class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;

        for(int left=0; left<nums.length - 1; left++) {
            for(int right=left+1; right<nums.length; right++) {
                if((nums[left] + 1)/2 > nums[right]) {
                    count ++;
                }
            }
        }

        return count;
    }

}


// Merge sort
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] elems, int begin, int end) {
        if (begin >= end) return 0;

        int mid = (begin + end) / 2;
        int count = mergeSort(elems, begin, mid) + mergeSort(elems, mid+1, end);

        for(int i=begin, j= mid+1; i<mid+1; i++) {
            while(j<=end && elems[i]/2.0 > elems[j] ) j++;
            count += j - (mid + 1);
        }
        // here it needs to be end + 1
        Arrays.sort(elems, begin, end + 1);
        return count;
    }

}
