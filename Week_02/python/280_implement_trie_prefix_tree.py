class TrieNode:
    def __init__(self):
        self.is_end = False
        self.links = [None for _ in range(26)]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root

        for ch in word:
            if not node.links[ord(ch) - ord('a')]:
                node.links[ord(ch) - ord('a')] = TrieNode()

            node = node.links[ord(ch) - ord('a')]

        node.is_end = True

    def search(self, word: str):
        node = self.root

        for ch in word:
            if node.links[ord(ch) - ord('a')] is None:
                return False

            node = node.links[ord(ch) - ord('a')]

        return node.is_end

    def start_with(self, prefix: str):
        node = self.root

        for ch in prefix:
            if not node.links[ord(ch) - ord('a')]:
                return False

            node = node.links[ord(ch) - ord('a')]

        return True
