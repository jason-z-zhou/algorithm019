from typing import List


class Solution0:
    def maxDistToClosest(self, seats: List[int]) -> int:
        full_seats = [i for i, seat in enumerate(seats) if seat == 1]

        max_dist = max(full_seats[0], len(seats) - full_seats[-1] - 1)

        for i in range(1, len(full_seats)):
            max_dist = max(max_dist, (full_seats[i] - full_seats[i - 1]) // 2)

        return max_dist


class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        max_dist = 0
        left, right = 0, 0

        while right < len(seats):
            if seats[right] == 1:
                dist = right if left == 0 and seats[left] == 0 else (right - left) // 2
                max_dist = max(max_dist, dist)
                left = right

            if right == len(seats) - 1:
                max_dist = max(max_dist, len(seats) - left - 1)
            right += 1

        return max_dist
