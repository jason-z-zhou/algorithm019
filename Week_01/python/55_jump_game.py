from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        furthest = 0

        for i, num in enumerate(nums):
            if furthest >= i:
                furthest = max(i + num, furthest)

        return furthest>= len(nums)-1
