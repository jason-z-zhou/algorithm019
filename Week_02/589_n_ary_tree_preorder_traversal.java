// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };

// Recursion
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(Node node, List<Integer> result){
        if(node == null ) return;

        result.add(node.val);
        for(Node child:node.children) {
            preorder(child, result);
        }
    }

}

// Stack

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Deque<Node> stack = new LinkedList<>();
        Node node = root;

        stack.push(node);

        while(!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);

            int childCount = node.children.size();

            for(int i=0; i< childCount; i++){
                Node child = node.children.get(childCount - i - 1);
                stack.push(child);
            }
        }

        return result;
    }

}
