// DFS
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for(int i=0; i<M.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, 1);
                count ++;
            }
        }

        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for(int j=0; j<M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

}

//并查集
class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int len = M.length;

        int[] p = new int[len];

        for(int i=0; i<len; i++) {
            p[i] = i;
        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(M[i][j] == 1) {
                    union(p, i, j);
                }
            }
        }

        Set<Integer> roots = new HashSet<>();

        for(int i=0; i<len; i++) {
            int root = parent(p, i);
            roots.add(parent(p, i));
            System.out.println(root);
        }
        return roots.size();
    }

    private void union(int[] p, int i, int j) {
        int parentI = parent(p, i);
        int parentJ = parent(p, j);
        p[parentJ] = parentI;
    }

    private int parent(int[] p, int i) {
        int root = i;
        while(p[root] != root) {
            root = p[root];
        }

        while(p[i] != i){
            int x = i;
            i = p[i];
            p[x] = root;
        }
        return root;
    }


}
