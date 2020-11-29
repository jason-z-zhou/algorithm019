class Solution {
    public static int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        List<String> steps = new LinkedList<String>();

        dfs(steps, start, end, bank, 0);

        return minStepCount;
    }

    private void dfs(List<String> steps, String start, String end, String[] bank, int stepCount) {

        if(diff(start,end) == 0) {
            minStepCount = Math.min(minStepCount, stepCount);
            return;
        }

        for(String piece: bank) {
            if(diff(start, piece) == 1 && stepCount<minStepCount) {
                if(!steps.contains(piece)) {
                    steps.add(piece);
                    dfs(steps, piece, end, bank, stepCount + 1);
                    steps.remove(piece);
                }
            }
        }
        return;
    }

    private int diff(String start, String end) {
        int len = start.length();
        int diff = 0;
        for(int i=0; i<len; i++) {
            if(start.charAt(i) != end.charAt(i)) diff++;
        }
        // System.out.println(start + "+" + end + ": diff=" + diff);

        return diff;
    }
}
