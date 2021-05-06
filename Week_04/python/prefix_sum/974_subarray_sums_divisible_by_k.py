from collections import defaultdict
from typing import List


class Solution:
    def subarraysDivByK(self, A: List[int], K: int) -> int:
        pre_sum = defaultdict(list)
        pre_sum[0] = [-1]

        curr_sum = 0
        for i, a in enumerate(A):
            curr_sum =  (curr_sum + a) % K
            pre_sum[curr_sum].append(i)

        ans = 0
        for k, v in pre_sum.items():
            x = len(v)
            ans += x * (x-1) // 2

        return ans
