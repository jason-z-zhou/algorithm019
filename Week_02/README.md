#学习笔记 Week2

## Assignment
[Java Set 文档](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
[Java Map 文档](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

### 写一个关于 HashMap 的小总结。
哈希表通常是数组+链表的解决方案，数组存放下标，因为会出现哈希碰撞，把元素以链表的形式存放元素，工程运用上不直接使用哈希表，一般使用HashMap或者HashSet，在java里面HashSet实现原理就是借用HashMap。

####效率
哈希碰撞Hash Collisions：不同的key得到相同的哈希值，可以增加一个维度，拉链式解决冲突。
哈希查询效率取决于碰撞效率，理想状态下，如果链表小，那么查找时间O(1)


####并发
HashMap不是线程安全的，可以使用ConcurrentHashMap，或者使用Collections.synchronizedMap方法来保证集合修改时的非同步访问。

####有序
HashMap不是有序的，要维持顺序可以使用LinkedHashMap。例如LRU的实现。

HashMap源码
