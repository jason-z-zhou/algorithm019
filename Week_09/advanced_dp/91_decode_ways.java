class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < len + 1; i ++){
            int oneNum = 1;
            int twoNum = 1;
            int singleDigit = Integer.parseInt(s.substring(i-1, i));
            String doubleDigitStr = s.substring(i-2, i);
            int doubleDigit = Integer.parseInt(doubleDigitStr);

            if (singleDigit > 26 || singleDigit < 1)
                oneNum = 0;
            if (doubleDigitStr.charAt(0) == '0')
                twoNum = 0;
            if (doubleDigit > 26 || doubleDigit < 1)
                twoNum = 0;

            dp[i] = oneNum * dp[i - 1] + twoNum * dp[i - 2];
        }

        return dp[len];
    }
}
