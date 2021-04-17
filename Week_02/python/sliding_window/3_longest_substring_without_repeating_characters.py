from collections import defaultdict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        curr_len = 0
        n = len(s)
        lookup = set()
        start = 0

        for end in range(n):
            curr_len += 1
            while s[end] in lookup:
                lookup.remove(s[start])
                start += 1
                curr_len -= 1

            if curr_len > max_len:
                max_len = curr_len

            lookup.add(s[end])

        return max_len


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1: return len(s)

        left, right = 0, 0
        window = defaultdict(int)
        max_len = -float('inf')

        while right < len(s):
            ch_r = s[right]
            right += 1
            window[ch_r] += 1

            while window[ch_r] > 1:
                ch_l = s[left]
                left += 1
                window[ch_l] -= 1

            max_len = max(max_len, right - left);

        return max_len
