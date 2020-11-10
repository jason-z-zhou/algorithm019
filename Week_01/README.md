# 学习笔记 Week 1:

## Assignment
- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
```
        // deque作为queue, addFirst = offer, removeLast = poll;
        Deque<String> queue = new LinkedList<>();
        queue.addFirst("a");
        queue.addFirst("b");
        queue.addFirst("c");

        System.out.println(queue);

        while (queue.size() > 0) {
            System.out.println(queue.removeLast());
        }
        System.out.println(queue);

        // deque作为stack, addFirst = push, removeFirst = pop;
        Deque<String> stack = new LinkedList<>();
        stack.addFirst("a");
        stack.addFirst("b");
        stack.addFirst("c");

        System.out.println(stack);

        while (queue.size() > 0) {
            System.out.println(stack.removeLast());
        }
        System.out.println(stack);

```


- 分析 Queue 的源码 [jdk 10] (https://docs.oracle.com/javase/10/docs/api/java/util/Queue.html)

    Queue作为Interface，继承Collection, 提供了对队列元素的增，删，查方法。每个方法有两种形式：一种是操作失败会抛出异常，另一种是返回一个特殊值 null 或 false

Summary of Queue methods: 


Method        |Throws exception  | Returns special value
------------- | ---------------  | --------------------- 
Insert	      |add(e)            | offer(e)
Remove	      |remove()          | poll()
Examine	      |element()         | peek()

- 分析 Priority Queue 的源码
优先队列的实现方式是使用二叉堆的结构，需要满足以下两条性质(Heap property 最小堆)：
1. 任何结点的值都小于或等于其子节点的值。
2. 所有结点从上到下，从左到右填入，即一棵完全二叉树。

PriorityQueue默认是最小堆，即堆顶元素最小。它的Constructor包含两个参数：initialCapacity 和 comparator
1. 可以重载comparator来实现最大堆
2. 堆的底层存储逻辑是数组
3. 当堆的大小超过initialCapacity，堆会重新生成一个double size的数组，把旧的的数组copy到新的里面。
4. 堆操作：add插入新元素Siftup，poll删除堆顶元素Siftdown
