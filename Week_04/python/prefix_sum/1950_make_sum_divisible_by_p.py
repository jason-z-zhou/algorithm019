from collections import defaultdict
from typing import List


class Solution0:
    def minSubarray(self, nums: List[int], p: int) -> int:
        if sum(nums) % p == 0: return 0

        t = sum(nums) % p
        look_up = defaultdict(list)
        window_sum = []
        curr_sum = 0
        for i, num in enumerate(nums):
            curr_sum = (curr_sum + num) % p
            look_up[curr_sum].append(i)
            window_sum.append(curr_sum)

        dist = min(look_up[t]) + 1 if len(look_up[t]) > 1 else float('inf')

        for idx, v in enumerate(window_sum):
            target = (v + t) % p
            candidates = look_up[target]
            for c in candidates:
                if c > idx:
                    dist = min(dist, c - idx)
                    break

        return dist if dist != float('inf') else -1


from itertools import product

class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        if sum(nums) % p == 0: return 0

        t = sum(nums) % p
        look_up = defaultdict(list)
        curr_sum = 0
        for i, num in enumerate(nums):
            curr_sum = (curr_sum + num) % p
            look_up[curr_sum].append(i)

        dist = min(look_up[t]) + 1 if len(look_up[t]) > 1 else float('inf')

        for k, v in look_up.items():
            if (k+t) % p in look_up:
                candidates = [y - x for x in v for y in look_up[(k+t) % p] if y > x]
                dist = min(candidates + [dist])

        return dist if dist != float('inf') else -1
