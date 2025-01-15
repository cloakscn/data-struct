# 内容
邻接表表示方法，节省空间

# 应用知识点
* LinkedList

# 性能
| 空间复杂度   | O(V + E)     |
|---------|--------------|
| 构造      | O(E * V)     |
| hasEdge | O(degree(v)) |
| adj     | O(degree(v)) |

# 缺点

# 优化
* 快速查重
  * 使用 HashSet O(1)
  * 使用 TreeSet O(logV)
    * 红黑树可以保证节点的顺序
    * 节省空间
    * O(logV) 很接近 O(1)
* 快速查看两点是否相邻