class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);

        for(int i = 0; i< res.size() - 1; i++) {
            if(res.get(i) >= res.get(i+1)) return false;
        }

        return true;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;

        inOrder(root.left, result);

        result.add(root.val);

        inOrder(root.right, result);

    }
}
