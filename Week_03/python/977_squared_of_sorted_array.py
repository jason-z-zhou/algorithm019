from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        left, right = 0, len(nums) - 1
        ans = []

        while left <= right:
            l_num, r_num = nums[left] ** 2, nums[right] ** 2
            if l_num < r_num:
                ans.append(r_num)
                right -= 1
            else:
                ans.append(l_num)
                left += 1

        return list(reversed(ans))

