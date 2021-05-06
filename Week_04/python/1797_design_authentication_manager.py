from collections import defaultdict


class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.ttl = timeToLive
        self.tokens = defaultdict(int)


    def generate(self, tokenId: str, currentTime: int) -> None:
        self.tokens[tokenId] = currentTime + self.ttl


    def renew(self, tokenId: str, currentTime: int) -> None:
        if not self.tokens[tokenId] or self.tokens[tokenId] <= currentTime:
            self.tokens.pop(tokenId)
            return

        self.tokens[tokenId] = currentTime + self.ttl


    def countUnexpiredTokens(self, currentTime: int) -> int:
        xtokens = [k for k,v in self.tokens.items() if v > currentTime]
        return len(xtokens)



# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)
