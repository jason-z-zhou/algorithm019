class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> lookup = new HashMap<>();
        int[] result = new int[k];

        for(int i=0; i< nums.length; i++) {
            lookup.put(nums[i], lookup.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Integer, Integer> entry: lookup.entrySet()) {
            maxHeap.add(entry);
        }

        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;

    }
}
