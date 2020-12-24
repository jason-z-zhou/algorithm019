class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, (left, right) -> left[0] - right[0]);

        List<int[]> merged = new ArrayList<>();

        for(int i=0; i<intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];

            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        // return merged.toArray(new int[merged.size()][]);

        int[][] ans = new int[merged.size()][2];

        for(int i=0; i<merged.size(); i++) {
            ans[i] = merged.get(i);
        }

        return ans;
    }

}
