import random
from typing import List


class Solution:

    def __init__(self, n_rows: int, n_cols: int):
        self.n_rows = n_rows
        self.n_cols = n_cols
        self.visited = set()
        self.num = n_rows * n_cols - 1


    def flip(self) -> List[int]:
        r = random.randint(0, self.num)

        while r in self.visited:
            r = random.randint(0, self.num)

        self.visited.add(r)

        return r // self.n_cols, r % self.n_cols



    def reset(self) -> None:
        self.visited = set()



# Your Solution object will be instantiated and called as such:
# obj = Solution(n_rows, n_cols)
# param_1 = obj.flip()
# obj.reset()
