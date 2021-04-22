class Solution {
    public List<List<String>> solveNQueens(int n) {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> colPlusRows = new HashSet<>();
        Set<Integer> colMinusRows = new HashSet<>();

        List<Integer> states = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        dfs(n, 0, states, result, cols, colPlusRows, colMinusRows);


        return generateResult(result, n);
    }


    private void dfs(int n, int row, List<Integer> states, List<List<Integer>> result, Set<Integer> cols, Set<Integer> colPlusRows, Set<Integer> colMinusRows) {

        if(row == n) {
            result.add(states);
        }

        for(int col = 0; col < n; col++){
            if(cols.contains(col) || colPlusRows.contains(col + row) || colMinusRows.contains(col - row)) {
                continue;
            }

            cols.add(col);
            colPlusRows.add(col + row);
            colMinusRows.add(col - row);

            List<Integer> newStates = new ArrayList<>(states);
            newStates.add(col);

            dfs(n, row + 1, newStates, result, cols, colPlusRows, colMinusRows);

            cols.remove(col);
            colPlusRows.remove(col + row);
            colMinusRows.remove(col - row);
        }
    }

    private List<List<String>> generateResult(List<List<Integer>> results_, int n) {
        List<List<String>> results = new ArrayList<>();

        for(List<Integer> result_: results_) {

            List<String> result = new ArrayList<>();

            for(int line_ : result_) {
                String line = "";

                for(int i=0; i < n; i++) {
                    if(i == line_) line+="Q";
                    else {
                        line +=".";
                    }
                }

                result.add(line);
            }

            results.add(result);
        }

        return results;
    }
}
