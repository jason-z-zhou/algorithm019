from collections import deque
from typing import List


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res = [0] * len(T)
        min_stack = deque()

        for i, t in enumerate(T):
            if not min_stack or t <= T[min_stack[-1]]:
                min_stack.append(i)

            while min_stack and t > T[min_stack[-1]]:
                x = min_stack.pop()
                res[x] = i - x

            min_stack.append(i)

        while min_stack:
            x = min_stack.pop()
            res[x] = 0

        return res
