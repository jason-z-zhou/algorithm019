from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        lookup = {}

        for i, num in enumerate(nums):
            if lookup.get(num) is not None:
                return [lookup.get(num), i]
            else:
                lookup[target - num] = i

        return []
