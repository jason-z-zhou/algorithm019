from typing import List


class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        res = []

        for num in arr:
            for piece in pieces:
                if num == piece[0]: res.extend(piece)


        return res == arr
