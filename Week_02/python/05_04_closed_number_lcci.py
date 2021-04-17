from typing import List


class Solution:
    def findClosedNumbers(self, num: int) -> List[int]:
        if num == 1: return 2, -1
        if num == 2147483647: return -1, -1

        b_str = bin(num)[2:]

        b_str = '0' + b_str

        l_index = b_str.rfind('01')
        r_index = b_str.rfind('10')

        large = b_str[:l_index] + "10" + self.shift_one_right(b_str[l_index + 2:])
        small = b_str[:r_index] + "01" + self.shift_one_left(b_str[r_index + 2:])

        print(b_str, large, small)

        return int(large, 2), int(small, 2)

    def shift_one_left(self, b_str: str):
        ones, zeros = b_str.count('1'), b_str.count('0')
        return '1' * ones + '0' * zeros

    def shift_one_right(self, b_str: str):
        ones, zeros = b_str.count('1'), b_str.count('0')
        return '0' * zeros + '1' * ones
