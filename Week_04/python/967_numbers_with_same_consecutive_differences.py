from typing import List


class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:

        res = []

        for i in range(n):
            if i == 0:
                res = list(range(1,10))
                continue

            new_res = []
            for ele in res:
                last_digit = ele % 10
                for x in range(0, 10):
                    if x in [last_digit-k, last_digit+k]:
                        new_res.append(ele * 10 + x)

            res = new_res

        return res
