import functools
from collections import Counter


class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2) or sorted(s1) != sorted(s2): return False
        return self.dfs(s1, s2)

    @functools.lru_cache(None)
    def dfs(self, s1: str, s2: str) -> bool:
        n = len(s1)
        if n == 1:
            return s1 == s2

        if Counter(s1) != Counter(s2):
            return False

        for i in range(1, n):
            if self.dfs(s1[:i], s2[:i]) and self.dfs(s1[i:], s2[i:]) \
                    or self.dfs(s1[:i], s2[n - i:]) and self.dfs(s1[i:], s2[:n - i]):
                return True

        return False
