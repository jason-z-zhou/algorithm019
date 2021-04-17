class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] res = new int[k];

        for(int i=0 ; i < arr.length ; i++){
            minHeap.add(arr[i]);
        }

        for(int i=0; i< k; i++) {
            res[i] = minHeap.poll();
        }

        return res;

    }
}
