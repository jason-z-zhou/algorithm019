from typing import List


class Solution:
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
