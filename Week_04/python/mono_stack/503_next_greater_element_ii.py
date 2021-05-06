from collections import deque
from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        nums = nums * 2
        res = [-1] * len(nums)

        down_stack = deque()
        for i, num in enumerate(nums):
            if not down_stack or num <= nums[down_stack[-1]]:
                down_stack.append(i)

            while down_stack and num > nums[down_stack[-1]]:
                x = down_stack.pop()
                res[x] = num
            down_stack.append(i)

        while down_stack:
            x = down_stack.pop()
            res[x] = -1

        return res[:len(nums) // 2]
