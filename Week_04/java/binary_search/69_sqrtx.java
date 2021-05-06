// Binary Search
class Solution0 {
    public int mySqrt(int x) {

        int left = 1, right = x, mid =1;

        while(left <= right) {
            System.out.println("left=" + left + ", mid=" + mid + ", right=" + right);

            if(mid * mid < x) {
                left = mid + 1;
            } else if( mid * mid > x) {
                right = mid - 1;
            } else {
                break;
            }

            mid = (left - right)/2 + right;
        }

        System.out.println("left=" + left + ", mid=" + mid + ", right=" + right);

        return mid;
    }
}

// Newton
class Solution1 {
    public int mySqrt(int x) {
        long res = x;
        while(res * res > x) {
            res = (res + x/res) /2;
        }

        return (int)res;
    }
}

