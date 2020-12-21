class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：初始化Wordset
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 0;
        while(!queue.isEmpty()) {
            step ++;
            int currentSize = queue.size();
            for(int i=0; i<currentSize; i++) {
                String curr = queue.poll();
                if(curr.equals(endWord)) return step;
                for(String word: wordList) {
                    if(!visited.contains(word) && diff(word, curr) == 1){
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }

    private int diff(String wordA, String wordB) {

        int diff = 0;

        for(int i = 0; i<wordA.length(); i++) {
            if(wordA.charAt(i) != wordB.charAt(i)) {
                diff ++;
            }
        }
        return diff;
    }
    
}
