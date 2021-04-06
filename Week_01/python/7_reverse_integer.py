class Solution:
    def reverse(self, x: int) -> int:
        y, res = abs(x), 0
        boundary = 2 ** 31 if x < 0 else 2 ** 31 - 1

        while y != 0:
            res = res * 10 + y % 10
            if res > boundary:
                return 0

            y //= 10

        return res if x > 0 else - res