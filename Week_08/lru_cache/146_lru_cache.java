class LRUCache {
    private HashMap<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.size = 0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size ++;
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

class DLinkedNode{
    DLinkedNode prev;
    DLinkedNode next;
    int key;
    int value;
    public DLinkedNode() {}
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
