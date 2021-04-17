class DLinkedNode:
    def __init__(self, key=None, value=None):
        self.pre = None
        self.nxt = None
        self.key = key
        self.value = value


class LRUCache:
    def __init__(self, capacity: int):
        self.cache = {}
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.size = 0
        self.capacity = capacity
        self.head.nxt = self.tail
        self.tail.pre = self.head

    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if not node:
            return -1

        self._move_to_head(node)

        return node.value

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if not node:
            new_node = DLinkedNode(key, value)
            self.cache[key] = new_node
            self._add_to_head(new_node)
            self.size += 1
            if self.size > self.capacity:
                tail = self._remove_tail()
                self.cache[tail.key] = None
                self.size -= 1

            return

        node.value = value
        self._move_to_head(node)

    def _move_to_head(self, node: DLinkedNode):
        self._remove_node(node)
        self._add_to_head(node)

    def _add_to_head(self, node: DLinkedNode):
        nxt = self.head.nxt
        self.head.nxt = node
        node.pre = self.head
        node.nxt = nxt
        nxt.pre = node

    def _remove_node(self, node: DLinkedNode):
        nxt = node.nxt
        pre = node.pre

        nxt.pre = pre
        pre.nxt = nxt

    def _remove_tail(self) -> DLinkedNode:
        node = self.tail.pre
        self._remove_node(node)
        return node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
