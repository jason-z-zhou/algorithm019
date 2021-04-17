from collections import defaultdict
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        left, right = 0, 0
        window, need = defaultdict(int), defaultdict(int)
        starts = []
        valid = 0

        for ch in p:
            need[ch] += 1

        while right < len(s):
            ch = s[right]
            right += 1

            if ch in need:
                window[ch] += 1
                if window[ch] == need[ch]:
                    valid += 1

            if right - left >= len(p):
                if valid == len(need):
                    starts.append(left)

                ch = s[left]
                left += 1

                if ch in need:
                    if window[ch] == need[ch]:
                        valid -= 1
                    window[ch] -= 1

        return starts
