from typing import List


class Solution:
    def backpack(self, bag_size: int, weights: List[int], values: List[int]) -> int:
        # 转化为背包问题
        item_cnt = len(weights)

        # dp[i][j] 表示从前i个物品里面挑选若干，总weight小于等于j时的最大价值
        dp = [[0 for _ in range(bag_size + 1)] for _ in range(item_cnt + 1)]

        for i in range(item_cnt):
            for j in range(1, bag_size + 1):
                dp[i][j] = dp[i - 1][j]

                if j >= weights[i]:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i])

        return dp[-1][-1]
