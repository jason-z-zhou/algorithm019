from collections import defaultdict
from typing import List


class TrieNode:
    def __init__(self):
        self.links = [None for _ in range(26)]
        self.words = []


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root

        for ch in word:
            idx = ord(ch) - ord('a')
            if not node.links[idx]:
                node.links[idx] = TrieNode()

            node = node.links[idx]
            if len(node.words) < 3:
                node.words.append(word)

    def search(self, prefix):
        node = self.root

        for ch in prefix:
            idx = ord(ch) - ord('a')
            if not node.links[idx]:
                return []

            node = node.links[idx]

        return node.words


class Solution:

    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products = sorted(products)
        ans = []

        trie = Trie()
        for product in products:
            trie.insert(product)

        for i in range(len(searchWord)):
            prefix = searchWord[:i + 1]
            words = trie.search(prefix)
            ans.append(words)

        return ans


class Solution0:

    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products = sorted(products)
        ans = [[] for _ in range(len(searchWord))]

        for product in products:
            cnt = 0

            for x in zip(product, searchWord):
                if len(set(x)) == 1:
                    if len(ans[cnt]) < 3:
                        ans[cnt].append(product)
                    cnt += 1
                else:
                    break

        return ans


class Solution1:

    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        dic = defaultdict(list)
        products = sorted(products)

        for product in products:
            for i in range(len(product)):
                key = product[:i + 1]
                if len(dic[key]) < 3:
                    dic[key].append(product)

        ans = []
        for i in range(len(searchWord)):
            prefix = searchWord[:i + 1]
            ans.append(dic[prefix])

        return ans
