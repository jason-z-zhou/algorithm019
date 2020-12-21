学习笔记 Week07

# Trie 并查集:

## 特性：  
1. 结点不存完整单词
2. 从根结点到某一结点，路径经过的字符连接起来成字符串
3. 每个结点的所有子结点路径代表的字符都不同

## 优点： 
最大限度地减少无谓的字符串比较，查询效率比哈希表高


## 分析单词搜索 2 用 Tire 树方式实现的时间复杂度
`public List<String> findWords(char[][] board, String[] words)`

假定board的size是M * N， words的size是K，每个word的平均长度L

word初始化: O(K)
遍历board，匹配第一个字符：O(M*N) * L，这里O(M*N)是遍历board的复杂度，拿出board[i][j]的元素后，因为并查集的root元素查找首字母是常数复杂度，所以只需要下探L次。因此时间复杂度是O(M * N * L) 


## 双向BFS
总结双向 BFS 代码模版，请同学们提交在学习总结中。


## 启发式搜索
启发式搜索，将普通的Queue出入操作，替换成使用PriotiryQueue，每次取出最有可能的元素。一个元素接近目标的的可能性，由启发函数判断。
