from typing import List


class Solution0(object):
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:

        p1, p2, tail = m - 1, n - 1, m + n - 1

        while p1 >= 0 or p2 >= 0:
            if p1 == -1 or p2 >= 0 and nums1[p1] < nums2[p2]:
                nums1[tail] = nums2[p2]
                p2 -= 1
            elif p2 == -1:
                nums1[tail] = nums1[p1]
                p1 -= 1
            elif nums1[p1] < nums2[p2]:
                nums1[tail] = nums2[p2]
                p2 -= 1
            else:
                nums1[tail] = nums1[p1]
                p1 -= 1
            tail -= 1


class Solution1(object):
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:

        p1, p2, tail = m - 1, n - 1, m + n - 1

        while p1 >= 0 or p2 >= 0:
            if p1 == -1 or p2 >= 0 and nums1[p1] < nums2[p2]:
                nums1[tail] = nums2[p2]
                p2 -= 1
            else:
                nums1[tail] = nums1[p1]
                p1 -= 1
            tail -= 1
