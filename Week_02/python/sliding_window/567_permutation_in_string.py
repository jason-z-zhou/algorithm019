from collections import defaultdict


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        left, right = 0, 0
        need, window = defaultdict(int), defaultdict(int)
        valid = 0

        for ch in s1:
            need[ch] += 1

        while right < len(s2):
            ch = s2[right]
            right += 1

            if ch in need:
                window[ch] += 1
                if window[ch] == need[ch]:
                    valid += 1

            while right - left >= len(s1):
                if valid == len(need):
                    return True

                d = s2[left]
                left += 1

                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -=1


        return False

