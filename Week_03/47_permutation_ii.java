class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0) return res;

        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(path);
            return;
        }

        for(int i=index; i<nums.length; i++){
            List<Integer> newPath = new ArrayList<Integer>(path);
            newPath.add(nums[i]);

            swap(nums, index, i);
            dfs(nums, index + 1, newPath, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
