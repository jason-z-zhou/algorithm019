// Classic backtracking
class Solution0{
    List<List<Integer>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<Integer> queens = new ArrayList<>();
        List<Integer> xySum = new ArrayList<>();
        List<Integer> xyDiff = new ArrayList<>();

        dfs(queens, xySum, xyDiff, n);

        List<List<String>> boards = new ArrayList<>();
        for(List<Integer> res: result) {
            List<String> board = generateBoard(res, n);
            boards.add(board);
        }

        return boards;
    }

    private void dfs(List<Integer> queens,
                     List<Integer> xySum,
                     List<Integer> xyDiff,
                     int queenCount) {

        int row = queens.size();
        if(row == queenCount) {
            result.add(queens);
            return;
        }

        for(int col=0; col<queenCount; col++) {
            if(!queens.contains(col) && !xySum.contains(row + col) && !xyDiff.contains(row - col)){
                List<Integer> newQueens = new ArrayList<>(queens);
                List<Integer> newXySum = new ArrayList<>(xySum);
                List<Integer> newXyDiff = new ArrayList<>(xyDiff);

                newQueens.add(col);
                newXySum.add(row + col);
                newXyDiff.add(row - col);
                dfs(newQueens, newXySum, newXyDiff, queenCount);
            }
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
