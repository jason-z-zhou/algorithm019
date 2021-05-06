class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int ylen = matrix.length, xlen = matrix[0].length;

        if(xlen ==0 || ylen == 0 || target < matrix[0][0] || target > matrix[ylen-1][xlen-1]) return false;

        int up = 0, down = ylen -1, midY = -1;

        while(up <= down) {
            midY = (down - up) / 2 + up;

            if(target > matrix[midY][xlen - 1]) {
                up = midY + 1;
            } else if(target < matrix[midY][0]){
                down = midY - 1;
            } else {
                break;
            }
        }

        int left = 0, right = xlen -1, midX = 0;

        while(left <= right) {
            midX = (right - left ) / 2 + left;
            if(target == matrix[midY][midX]) return true;
            if(target > matrix[midY][midX]) {
                left = midX + 1;
            } else {
                right = midX - 1;
            }
        }

        return false;

    }
}
