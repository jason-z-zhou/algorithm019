from typing import List


class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        if len(nums) <=2: return 0

        even_ans, odd_ans = 0, 0

        for i in range(0, len(nums)):
            left_gap = nums[i] - nums[i-1] + 1 if i - 1 >= 0 and nums[i] - nums[i-1] >= 0 else 0
            right_gap = nums[i] - nums[i+1] + 1 if i + 1 < len(nums) and nums[i] - nums[i+1] >= 0 else 0
            if i % 2 == 0:
                even_ans += max(left_gap, right_gap)
            else:
                odd_ans += max(left_gap, right_gap)

        return min(even_ans, odd_ans)
