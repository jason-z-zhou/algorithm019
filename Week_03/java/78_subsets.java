class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0) return res;

        List<Integer> path = new ArrayList<>();

        dfs(res, nums, path, 0);

        return res;
    }


    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, int index) {
        if(index == nums.length) {
            result.add(path);
            return;
        }

        // divide

        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(nums[index]);

        dfs(result, nums, newPath, index + 1);
        dfs(result, nums, path, index + 1);
    }
}
