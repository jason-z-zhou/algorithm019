from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        # 转化为背包问题
        bag_size = sum(nums)
        item_cnt = len(nums)

        if bag_size%2 != 0:
            return False

        bag_size = bag_size//2
        # dp[i][j] 表示从前i个物品里面挑选若干，总重量小于等于j时的最大重量
        dp = [[0 for i in range(bag_size + 1)] for j in range(item_cnt + 1)]

        for i in range(1, item_cnt + 1):
            for j in range(1, bag_size + 1):
                if (j - nums[i - 1] < 0):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i-1][j-nums[i-1]] + nums[i-1], dp[i-1][j])

        return dp[item_cnt][bag_size] == bag_size
