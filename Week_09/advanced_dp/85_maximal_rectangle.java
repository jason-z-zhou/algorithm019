class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int nr = matrix.length, nc = matrix[0].length;

        int[][] dp = new int[nr][nc];
        int size = 0;

        for(int row=0; row<nr; row++) {
            for(int col=0; col<nc; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = col==0 ? 1 : dp[row][col-1] + 1;
                    int width = dp[row][col];

                    for(int r=row; r>=0 && matrix[r][col] == '1'; r--) {
                        width = Math.min(width, dp[r][col]);
                        size = Math.max(size, width * (row - r + 1));
                    }
                }
            }
        }

        return size;
    }

}
