// 传统循环
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i=0; i<=num; i++) {
            result[i] = count(i);
        }

        return result;
    }

    private int count(int n) {
        int count = 0;

        while(n != 0) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }

}

// DP
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i=1; i<=num; i++) {
            result[i] = result[i & (i-1)] + 1;
        }

        return result;
    }

}
