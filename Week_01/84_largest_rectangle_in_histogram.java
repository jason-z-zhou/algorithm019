// Brutal Force
class Solution0 {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;

        for( int i = 0; i< heights.length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i; j<heights.length; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j-i+1));
            }
        }

        return maxArea;

    }
}

// Use stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}

