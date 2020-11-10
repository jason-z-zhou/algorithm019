class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > left) {
                    left = height[j];
                }
            }

            int right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > right) {
                    right = height[j];
                }
            }

            int min = Math.min(left, right);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
