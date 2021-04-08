
class Solution:
    def countOrders(self, n: int) -> int:
        if n == 1: return 1
        pd = [0] * (n+1)

        pd[1] = 1

        for i in range(2, n+1):
            pd[i] = (pd[i-1] * (2*i-1)*i) % (10**9 + 7)


        return pd[n]
