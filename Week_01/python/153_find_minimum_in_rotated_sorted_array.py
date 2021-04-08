from typing import List


class Solution0:
    def findMin(self, nums: List[int]) -> int:
        return min(nums)


class Solution1:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1: return nums[0]

        for ind in range(1, len(nums)):
            if nums[ind] <= nums[ind - 1]:
                break

        return nums[ind] if nums[ind] <= nums[ind - 1] else nums[0]


class Solution2:
    def findMin(self, nums:List[int]) -> int:
        if len(nums) == 1: return nums[0]
        left, right = 0, len(nums)-1

        while left < right:
            mid = (right - left) // 2 + left
            if nums[mid] > nums[left]:
                left = mid + 1
            else:
                right = mid

        return nums[left]
