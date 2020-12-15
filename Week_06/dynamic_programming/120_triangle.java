class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int height = triangle.size();

        int[][] df = new int[height][height];

        df[0][0] = triangle.get(0).get(0);

        for(int i=1; i<height; i++) {
            for(int j=0; j<=i; j++) {
                int current = triangle.get(i).get(j);
                if (j==0) df[i][j] = df[i-1][0] + current;
                else if (j==i) df[i][j] = df[i-1][i-1] + current;
                else df[i][j] = Math.min(df[i-1][j], df[i-1][j-1]) + current;
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j=0; j<height; j++) {
            min = Math.min(df[height-1][j], min);
        }

        return min;
    }
}
