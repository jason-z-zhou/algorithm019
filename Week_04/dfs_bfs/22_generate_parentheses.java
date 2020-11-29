class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        dfs(n, n, res, "");
        return res;
    }

    public void dfs(int left, int right, List<String> res, String path) {
        if(left == 0 && right == 0) {
            res.add(path);
            return;
        }

        if(left > 0) {
            dfs(left-1, right, res, path + "(");
        }

        if(left < right) {
            dfs(left, right-1, res, path + ")");
        }

    }

}
