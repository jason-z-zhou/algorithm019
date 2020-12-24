class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] ans = new int[arr1.length];

        for(int a1: arr1) {
            bucket[a1] ++;
        }

        int count = 0;
        for(int a2: arr2) {
            while(bucket[a2] > 0) {
                ans[count ++] = a2;
                bucket[a2] --;
            }
        }

        for(int i=0; i<bucket.length; i++) {
            while(bucket[i] > 0 ) {
                ans[count ++] = i;
                bucket[i] --;
            }
        }
        return ans;
    }

}
