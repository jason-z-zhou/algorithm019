class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];

        int i = 0, j = 0, k=0;

        while( i<m || j<n){
            if(i<m && j<n){
                res[k++] = (nums1[i] < nums2[j]) ? nums1[i++]: nums2[j++];
            }
            else if(i >= m) {
                res[k++] = nums2[j++];
            }
            else if(j >= n) {
                res[k++] = nums1[i++];
            }
        }
        System.arraycopy(res, 0, nums1, 0, m+n);
    }
}
