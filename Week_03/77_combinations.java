// Try to reuse the same code from Permutation
// Deduplicate the result (time complexity is N*N)
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if(n == 0 || k > n) return result;


        List<Integer> path = new ArrayList<>();

        int[] nums = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }

        dfs(nums, k, 0, path, result);
        return deduplicate(result);
    }


    private List<List<Integer>> deduplicate(List<List<Integer>> result) {

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> r : result) {
            boolean shouldAdd = true;
            for(int i=0; i< r.size() - 1; i++) {
                if(r.get(i) > r.get(i+1)) {
                    shouldAdd = false;
                    break;
                }
            }

            if(shouldAdd) {
                res.add(r);
            }
        }

        return res;
    }

    private void dfs(int[] nums, int k, int index, List<Integer> path, List<List<Integer>> result) {
        if( index == k) {
            result.add(path);
            return;
        }

        for(int i=index; i< nums.length; i++) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);
            swap(nums, index, i);
            dfs(nums, k, index+1, newPath, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
