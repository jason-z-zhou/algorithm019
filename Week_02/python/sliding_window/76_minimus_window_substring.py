from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        left, right = 0, 0
        window, need = defaultdict(int), defaultdict(int)

        for ch in t:
            need[ch] += 1

        print(need)
        valid = 0
        start, length = 0, float('inf')

        while right < len(s):
            ch = s[right]
            right += 1

            if ch in need:
                window[ch] += 1
                if window[ch] == need[ch]:
                    valid += 1

            while valid == len(need):
                if right - left < length:
                    start = left
                    length = right - left

                d = s[left]
                left += 1

                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1

        return "" if length == float('inf') else s[start:start+length]

