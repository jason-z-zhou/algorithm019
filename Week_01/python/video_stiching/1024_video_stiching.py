from typing import List


class Solution0:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        clips.sort()

        dp = [0] + [float("inf")] * T

        for i in range(1, 1 + T):
            for left, right in clips:
                if left < i <= right:
                    dp[i] = min(dp[i], dp[j] + 1)

        return -1 if dp[T] == float("inf") else dp[T]


class Solution1:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        leftmost = [x for x in range(T + 1)]

        for left, right in clips:
            left = max(left, 0)
            right = min(right, T)
            leftmost[right] = min(left, leftmost[right])

        dp = [0] + [float("inf")] * T

        for i in range(1, 1 + T):
            for j in range(leftmost[i], i):
                dp[i] = min(dp[i], dp[j] + 1)

        return -1 if dp[T] == float("inf") else dp[T]


class Solution2:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        rightmost = [x for x in range(T+1)]

        for left, right in clips:
            left = min(max(left, 0), T)
            right = min(max(right, 0), T)
            rightmost[left] = max(right, rightmost[left])

        dp = [0] + [float('inf')] * T

        for i in range(0, 1+T):
            for j in range(i, rightmost[i] + 1):
                dp[j] = min(dp[j], dp[i] + 1)


        return -1 if dp[T] == float('inf') else dp[T]
