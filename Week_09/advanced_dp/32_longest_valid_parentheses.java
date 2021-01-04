class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];

        int max = 0;

        Arrays.fill(dp, 0);

        for(int i=1; i< len; i++) {
            char right  = s.charAt(i);
            if(right == ')') {
                System.out.println(i);
                if(i - dp[i-1] - 1 >= 0) {
                    char left = s.charAt(i - dp[i-1] - 1);
                    if(left == '(') {
                        dp[i] = 2 + dp[i-1];
                        if(i-dp[i-1]-2 >= 0) {
                            dp[i] += dp[i - dp[i-1] - 2];
                        }
                    }
                }
            }
            System.out.println(dp[i]);

            max = max > dp[i] ? max: dp[i];
        }

        return max;
    }

}
