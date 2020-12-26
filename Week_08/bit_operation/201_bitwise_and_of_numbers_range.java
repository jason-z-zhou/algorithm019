class Solution0 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;

        for(int i=m+1; i<=n; i++) {
            res = res & i;
            if(res == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }

        return res;

    }
}


class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;

        while( m != n) {
            m = m >> 1;
            n = n >> 1;
            count ++;
        }

        return m << count;
    }
}
