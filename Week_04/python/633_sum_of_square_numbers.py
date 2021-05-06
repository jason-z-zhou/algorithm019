from math import sqrt


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        left, right = 0, int(sqrt(c)) + 1

        p = [i * i for i in range(0, right+1)]

        while left <= right:
            if p[left] + p[right]  < c:
                left += 1
            elif p[left] + p[right] > c:
                right -= 1
            else:
                return True

        return False
