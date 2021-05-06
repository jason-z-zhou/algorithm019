from typing import List


class Solution:
    def decode(self, encoded: List[int], first: int) -> List[int]:
        res = [first]

        curr = first
        for x in encoded:
            res += [ curr ^ x]
            curr = curr ^ x

        return res
