from collections import deque


class Solution0:
    def isValid(self, s: str) -> bool:
        pairs = {'[': ']', '{': '}', '(': ')'}
        dq = deque()
        dq.append("$")
        for ch in s:
            if ch in pairs:
                dq.append(pairs[ch])
            elif dq.pop() != ch:
                return False

        return len(dq) == 1


class Solution1:
    def isValid(self, s: str) -> bool:
        pairs = {'[': ']', '{': '}', '(': ')'}
        dq = deque()
        for ch in s:
            if ch in pairs:
                dq.append(ch)
            elif not dq or pairs.get(dq.pop()) != ch:
                return False

        return not dq
