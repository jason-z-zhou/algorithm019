class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board.length; c++) {
                char num = board[r][c];
                if(num != '.') {
                    int n = (int) num;
                    int boxIndex = (r / 3) * 3 + c / 3;
                    rows[r].put(n, rows[r].getOrDefault(n, 0) + 1);
                    columns[c].put(n, columns[c].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                    if(rows[r].get(n) > 1 || columns[c].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
