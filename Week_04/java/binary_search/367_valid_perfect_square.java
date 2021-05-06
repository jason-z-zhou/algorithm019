class Solution {
    public boolean isPerfectSquare(int num) {

        int left = 1, right = num, mid = 1;

        while(left <= right) {
            if(mid * mid == num) break;
            else if(mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = (right - left)/2 + left;
        }

        return mid * mid == num ;
    }
}
