from typing import List


class Solution0:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:

        res = [-1] * len(nums1)

        for i, n1 in enumerate(nums1):
            skip = True
            for n2 in nums2:
                if skip:
                    skip = False if n2 == n1 else True
                    continue

                if not skip and n2 > n1:
                    res[i] = n2
                    break

        return res


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        next_greater = dict()
        mono_stack = deque()

        for i, n2 in enumerate(nums2):
            if not mono_stack or n2 < mono_stack[-1]:
                mono_stack.append(n2)
                continue

            while len(mono_stack) > 0 and n2 > mono_stack[-1]:
                x = mono_stack.pop()
                next_greater[x] = n2

            mono_stack.append(n2)

        while len(mono_stack) > 0:
            x = mono_stack.pop()
            next_greater[x] = -1

        ans = []
        for n1 in nums1:
            ans.append(next_greater[n1])

        return ans
