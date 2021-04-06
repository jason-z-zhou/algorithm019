from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums) - 1
        mid = (left - right) // 2 + right

        while left < right:
            mid = (left - right) // 2 + right
            print(left, " ", mid, " ", right, " ")

            if target in [nums[mid],  nums[left], nums[right]]: return True

            if nums[mid] > nums[left]:
                if nums[mid] > target > nums[left]: right = mid - 1
                else: left = mid + 1
            elif nums[mid] < nums[left]:
                if nums[mid] < target < nums[right]: left = mid + 1
                else: right = mid - 1
            else:
                # 点睛之笔，如果mid和left的同值，则left++
                left += 1

        return nums[mid] == target

