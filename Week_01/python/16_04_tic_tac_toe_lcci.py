from functools import reduce
from typing import List

class Solution:
    def tictactoe(self, board: List[str]) -> str:
        n = len(board)

        cols = ["".join([b[i] for b in board]) for i in range(n)]
        crxs = ["".join([board[i][i] for i in range(n)]),
                "".join([board[i][n-i-1] for i in range(n)])]

        checks = board + cols + crxs

        for check in checks:
            if check == "O" * n : return "O"
            if check == "X" * n : return "X"

        return "Pending" if " " in "".join(board) else "Draw"
