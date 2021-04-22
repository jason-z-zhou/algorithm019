class Solution:
    def alphabetBoardPath(self, target: str) -> str:

        path = ""
        coord = [(t % 5, t // 5) for t in [ord(x) - ord('a') for x in target] ]

        for i in range(len(coord)):
            curr = coord[i]
            prev = coord[i-1] if i>0 else (0,0)
            x, y = curr[0] - prev[0], curr[1] - prev[1]

            xpath = ("R" * x) if x>0 else ("L" * -x)
            ypath = ("D" * y) if y>0 else ("U" * -y)

            if target[i] == 'z':
                path += (xpath + ypath)
            else:
                path += (ypath + xpath)
            path += "!"


        return path




