from itertools import product
from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letters_by_number = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

        words = []
        for digit in digits:
            next_letters = list(letters_by_number[int(digit) - 2])
            if len(words) == 0:
                words = next_letters
                continue
            words = [w + l for w, l in product(words, next_letters)]

        return words
