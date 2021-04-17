from collections import defaultdict, OrderedDict


class Node:
    def __init__(self, key, value, freq):
        self.key = key
        self.value = value
        self.freq = freq


class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.freqs = defaultdict(OrderedDict)
        self.caches = defaultdict(Node)
        self.min_freq = 0

    def get(self, key: int) -> int:
        if key not in self.caches or not self.capacity:
            return -1
        else:
            node = self.caches[key]
            self.increase_freq(node)
            return node.value

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return None

        if key not in self.caches and len(self.caches) == self.capacity:
            self.remove_least_freq()

        if key not in self.caches:
            node = Node(key, value, 1)
            self.add_node(node)
        else:
            node = self.caches[key]
            node.value = value
            self.increase_freq(node)

    def increase_freq(self, node):
        k, v, f = node.key, node.value, node.freq
        self.freqs[f].move_to_end(k)
        self.freqs[f].popitem()
        if f == self.min_freq and len(self.freqs[f]) == 0:
            self.min_freq += 1
        f += 1
        node = Node(k, v, f)
        self.freqs[f][k] = node
        self.caches[k] = node
        return node

    def add_node(self, node):
        key = node.key
        self.caches[key] = node
        self.freqs[1][key] = node
        self.min_freq = 1

    def remove_least_freq(self):
        _, node = self.freqs[self.min_freq].popitem(last=False)
        if len(self.freqs[self.min_freq]) == 0:
            self.min_freq += 1
        del self.caches[node.key]
