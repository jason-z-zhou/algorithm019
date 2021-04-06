from collections import deque


class Solution0:
    def reverseParentheses(self, s: str) -> str:
        stack, tmp = deque(), deque()

        for ch in s:
            if ch != ')': stack.append(ch)
            else:
                while stack and stack[-1] != '(':
                    tmp.append(stack.pop())

                stack.pop()

                while tmp:
                    stack.append(tmp.popleft())

        s = ""

        while stack:
            s += stack.popleft()

        return s


class Solution1:
    def reverseParentheses(self, s: str) -> str:
        stack, tmp = deque(), deque()

        for ch in s:
            if ch != ')': stack.append(ch)
            else:
                while stack[-1] != '(':
                    tmp.append(stack.pop())

                stack.pop()

                while tmp:
                    stack.append(tmp.popleft())

        return "".join(stack)
