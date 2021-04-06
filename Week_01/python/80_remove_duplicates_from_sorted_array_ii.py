from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        if len(nums) < 3: return len(nums)

        ind, l = 0, len(nums)

        while ind <= l - 3:
            if nums[ind] != nums[ind + 2]:
                ind += 1
            else:
                nums.pop(ind + 2)
                l = len(nums)

        return len(nums)



class Solution:
    def removeDuplicates(self, nums: List[int], k: int) -> int:

        if len(nums) <= k: return len(nums)

        ind, l = 0, len(nums)

        while ind < l - k:
            if nums[ind] != nums[ind + k]:
                ind += 1
            else:
                nums.pop(ind + k)
                l = len(nums)

        return len(nums)
