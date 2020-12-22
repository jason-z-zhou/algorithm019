// Classic backtracking
class Solution0{
    private int count;
    private int size;

    public int totalNQueens(int n) {
        count = 0;
        // 当n=8时，size=11111111
        size = ( 1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if(row == size) {
            count ++;
            return;
        }

        // pos里面的1，对应size里面的1，和row, rd, ld里面全是0的bit
        in pos = size & (~(row | ld | rd));
        while(pos != 0) {
            // couldn't really understand these three lines.
            int p = pos & (-pos);
            pos = pos - p; //当前位置放上皇后
            solve(row | p,(ld | p) << 1, (rd | p) >> 1);
        }
    }

    public List<String> generateBoard(List<Integer> queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
