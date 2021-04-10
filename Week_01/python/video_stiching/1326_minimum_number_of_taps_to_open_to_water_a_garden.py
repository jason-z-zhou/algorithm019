from typing import List


class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:

        new_ranges = []

        for ind, r in enumerate(ranges):
            new_ranges.append([max(ind - r, 0), min(ind + r, n)])

        dp = [0] + [float('inf')] * n

        for i in range(1, n + 1):
            for left, right in new_ranges:
                if left < i <= right:
                    dp[i] = min(dp[i], dp[left] + 1)

        return -1 if dp[n] == float('inf') else dp[n]


class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        leftmost = [x for x in range(n + 1)]

        for ind, r in enumerate(ranges):
            L = max(ind - r, 0)
            R = min(ind + r, n)
            leftmost[R] = min(L, leftmost[R])

        dp = [0] + [float('inf')] * n

        for i in range(1, n + 1):
            for j in range(leftmost[i], i):
                dp[i] = min(dp[i], dp[j] + 1)

        return -1 if dp[n] == float('inf') else dp[n]
