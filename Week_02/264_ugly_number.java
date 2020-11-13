
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seens = new HashSet<>();
        minHeap.add(1L);
        long current = 1L;
        for(int i=0; i<n; ){
            current = minHeap.poll();
            if(!seens.contains(current)) {
                seens.add(current);
                if(!minHeap.contains(current * 2)) minHeap.add(current * 2);
                if(!minHeap.contains(current * 3)) minHeap.add(current * 3);
                if(!minHeap.contains(current * 5)) minHeap.add(current * 5);
                i++;
            }

        }

        return (int)current;
    }

}
