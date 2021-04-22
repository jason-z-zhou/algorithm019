class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == "0": return 0

        dp = [[0] * 2 for _ in range(len(s))]

        for i in range(len(s)):
            if i == 0:
                dp[0][0] = 1
                dp[0][1] = 0
                continue

            single = int(s[i])
            double = int(s[i - 1:i + 1])

            if double == 0:
                dp[i][0] = 0
                dp[i][1] = 0

            if double in range(1, 10):
                dp[i][0] = dp[i - 1][1]
                dp[i][1] = 0

            if double in [10, 20]:
                dp[i][0] = 0
                dp[i][1] = dp[i - 1][0]

            if double in list(range(11, 20)) + list(range(21, 27)):
                dp[i][0] = dp[i - 1][1] + dp[i - 1][0]
                dp[i][1] = dp[i - 1][0]

            if double >= 27:
                dp[i][0] = dp[i - 1][1] + dp[i - 1][0] if single != 0 else 0
                dp[i][1] = 0

        return sum(dp[-1])
