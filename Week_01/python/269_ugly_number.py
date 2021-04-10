class Solution:
    def isUgly(self, n: int) -> bool:
        while n > 1:
            if n % 2 == 0:
                n //= 2
                continue

            if n % 3 == 0:
                n //= 3
                continue

            if n % 5 == 0:
                n //= 5
                continue
            break

        return n == 1


class Solution1:
    def isUgly(self, n: int) -> bool:
        if n <= 0: return False
        factors = [2,3,5]
        for factor in factors:
            while n % factor == 0:
                n //= factor

        return n == 1
