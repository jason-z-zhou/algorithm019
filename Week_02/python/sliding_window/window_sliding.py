
class Solution:
    def windowSliding(self, s: str):
        left, right = 0, 0
        window = ...

        while right < len(s):
            window.add(s[right])
            right += 1

            while window.need_shrink():
                window.remove(s[left])
                left += 1

