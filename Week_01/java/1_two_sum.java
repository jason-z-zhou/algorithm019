class Solution0 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[0];

    }
}


class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            int num = nums[i];
            if(lookup.containsKey(num)) {
                return new int[]{lookup.get(num), i};
            }

            lookup.put(target - num, i);
        }

        return new int[0];
    }
}
