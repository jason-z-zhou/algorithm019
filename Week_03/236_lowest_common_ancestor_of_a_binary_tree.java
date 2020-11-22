
// Solution 0: Use hashMap
// Lookup table: node val is key, and its direct parent as value
class Solution0 {
    HashMap<Integer, TreeNode> parentLookup = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while(p!=null) {
            System.out.println(p.val);
            visited.add(p.val);
            TreeNode parent = parentLookup.get(p.val);
            p = parent;
        }

        while(q!=null) {
            System.out.println(q.val);
            if(visited.contains(q.val)) return q;
            TreeNode parent = parentLookup.get(q.val);
            q = parent;

        }

        return null;
    }

    public void dfs(TreeNode root){
        if(root.left != null) {
            parentLookup.put(root.left.val, root);
            dfs(root.left);
        }

        if(root.right != null) {
            parentLookup.put(root.right.val, root);
            dfs(root.right);
        }
    }
}

// Solution 1: Recursion

class Solution {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if((lson && rson) || ((root == p || root == q) && (lson || rson))) {
            res = root;
        }

        return lson || rson || root == p || root ==q;
    }

}
