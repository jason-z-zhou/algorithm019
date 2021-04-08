class Solution0:
    def isRobotBounded(self, instructions: str) -> bool:
        instructions *= 4
        x, y, direction = [0, 0, 0]

        for ch in instructions:
            if ch == 'L':
                direction = (direction - 1) % 4
            elif ch == 'R':
                direction = (direction + 1) % 4
            else:
                if direction == 0:
                    y += 1
                elif direction == 1:
                    x += 1
                elif direction == 2:
                    y -= 1
                else:
                    x -= 1

        return x == 0 and y == 0


class Solution1:
    def isRobotBounded(self, instructions: str) -> bool:
        instructions *= 4
        x, y, d = [0, 0, 0]
        DIRS = [[1,0], [0,1], [-1,0], [0, -1]]

        for ch in instructions:
            if ch == 'L':
                d = (d - 1) % 4
            elif ch == 'R':
                d = (d + 1) % 4
            else:
                x += DIRS[d][0]
                y += DIRS[d][1]

        return x == 0 and y == 0
