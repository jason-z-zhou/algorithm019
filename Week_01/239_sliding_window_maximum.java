// Brutal Force
class Solution0 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];

        Arrays.fill(res, Integer.MIN_VALUE);

        for(int i=0; i<len-k+1; i++){
            for(int j=0; j<k; j++){
                res[i] = Math.max(res[i], nums[i+j]);
            }
        }

        return res;
    }
}

// deque

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k == 0) return new int[0];
        if(k == 1) return nums;

        int[] res = new int[len-k+1];
        Deque<Integer> deque = new LinkedList<Integer>();

        Arrays.fill(res, Integer.MIN_VALUE);

        for(int i=0; i<len; i++){

            // 如果队列尾部元素小于新的元素，则弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            // 新元素入队列
            deque.addLast(i);

            // 检查左首元素是否越界，然后修正
            if(deque.peekFirst() < i-k){
                deque.pollFirst();
            }

            // 当元素多于k个，队首元素为最大值
            if(i+1 >= k) {
                res[i+1-k] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

}
