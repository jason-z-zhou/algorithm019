from typing import List

# 问题： 有多少兑换方法使总额为amout
# 注意区别换硬币和走楼梯，前者是组合问题，后者是排列问题

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)

        dp[0] = 1

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i-coin]

        return dp[amount]
