class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) return res;
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> levelRes = new LinkedList<>();
            int levelQueueSize = queue.size();
            for(int i=0; i< levelQueueSize; i++){
                Node node = queue.poll();
                levelRes.add(node.val);
                for(Node child: node.children) {
                    if(child != null) {
                        queue.add(child);
                    }
                }
            }
            res.add(levelRes);
            levelRes = null;
        }

        return res;

    }
}
