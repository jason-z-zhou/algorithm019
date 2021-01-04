// Solution 1: 中心枚举
class Solution0 {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for(int i=0; i<s.length(); i++){
            int[] singleCore = expandAround(s, i, i);
            int[] doubleCore = expandAround(s, i, i + 1);

            if(singleCore[1] - singleCore[0] > end - start) {
                start = singleCore[0];
                end = singleCore[1];
            }

            if(doubleCore[1] - doubleCore[0] > end - start) {
                start = doubleCore[0];
                end = doubleCore[1];
            }
        }

        return s.substring(start, end+1);
    }

    private int[] expandAround(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return new int[]{left + 1, right - 1};
    }
}

// Solution 2: dp

class Solution {
    int n = s.length();
    String res = "";
    boolean[][] dp = new boolean[n][n];

    for(int  i=0; i<n; i++) {
        for(int j=i; j<n; j++) {
            dp[i][j] = s.charAt(i) ==s.charAt(j) && (j-i < 2 || dp[i+1][j-1]);
            if(dp[i][j] && j - i + 1 > res.length()) {
                res  = s.substring(i, j+1);
            }
        }
    }

    return res;
}
