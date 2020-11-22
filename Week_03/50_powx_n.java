class Solution {
    public double myPow(double x, int n) {
        if( n < 0 ) return 1.0/myPow(x, -n);

        if( n == 0) return 1.0;

        double subResult = myPow(x, n /2);

        if(n % 2 == 0) {
            return subResult * subResult;
        } else {
            return subResult * subResult * x;
        }
    }
}
