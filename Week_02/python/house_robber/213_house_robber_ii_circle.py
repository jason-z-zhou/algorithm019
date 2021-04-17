from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1: return nums[0]
        if n == 2: return max(nums)

        nums_1 = self.simple_rob(nums)
        nums_2 = self.simple_rob([nums[-1]] + nums[:-1])

        return max(nums_1, nums_2)

    def simple_rob(self, nums: List[int]) -> int:
        dp = [[0] * 2 for _ in range(len(nums))]

        dp[0][0] = 0
        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            dp[i][1] = dp[i-1][0] + nums[i]

        return max(dp[-1][0], dp[-1][1])

