/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// Recusion
class Solution0 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();

        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if(root == null) return;
        for(Node child : root.children) {
            helper(child, result);
        }
        result.add(root.val);
    }

}

// Stack: v right left -> left right v
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<Node> stack = new LinkedList<Node>();

        if(root == null) return result;

        Node node = root;
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.poll();
            result.add(node.val);
            for(Node child : node.children) {
                if(child != null) {
                    stack.push(child);
                }
            }
        }

        Collections.reverse(result);

        return result;
    }
}
