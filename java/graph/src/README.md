# 图基本表示的比较

| -               | 空间       | 建图时间                   | 查看两点是否相邻             | 查找点的所有邻边             | 备注                        |
|-----------------|----------|------------------------|----------------------|----------------------|---------------------------|
| 邻接矩阵            | O(V^2)   | O(E)                   | O(1)                 | O(V)                 | 性能最优，非常占空间（不推荐）           |
| 邻接表（LinkedList） | O(V + E) | O(E) <br>如果查重：O(E * V) | O(degree(v))<br>O(V) | O(degree(v))<br>O(V) | 邻接矩阵的优化，节省了空间（不推荐）        |
| 邻接表（TreeSet）    | O(V + E) | O(E*logV)              | O(logV)              | O(degree(v))<br>O(V) | 邻接矩阵的优化，保证了邻边的**顺序性**（推荐） |
| 邻接表（HashSet）    | O(V + E) | O(E)                   | O(1)                 | O(degree(v))<br>O(V) | 邻接矩阵的优化，提升了**性能**（推荐）     |

# 深度优先遍历

```shell
# 递归
visited[0...V-1] = false;
dfs(0);

dfs(int v) {
  visited[v] = true;
  list.add(v);
  for(int w : adj(v)) {
    if(!visited[w]) {
      dfs(w)
      }
    }
}
# 非递归
visited[0...V-1] = false;

for (int v = 0; v < V; v++) {
  if (!visited[v])
    bfs(v);
}

dfs(int s) {
  stack.add(s)
  visited[s] = true;
  while(!stack.isEmpty()) {
    int v = stack.remove();
    
    for (int w : G.adj(v)) {
      if (!visited[w]) {
        stack.add(w);
        visited[w] = true;
        }
    }
  }
}
```

* 深度优先遍历的非递归实现
* 图的邻接矩阵的深度优先遍历

# 联通分量

## 联通分量求路径

### 欧拉路径

### 哈米尔顿路径

### 最短路径

# 广度优先遍历

> BFS 只能用于无权图

```shell
visited[0...V-1] = false;

for (int v = 0; v < V; v++) {
  if (!visited[v])
    bfs(v);
}

bfs(int s) {
  queue.add(s)
  visited[s] = true;
  while(!queue.isEmpty()) {
    int v = queue.remove();
    
    for (int w : G.adj(v)) {
      if (!visited[w]) {
        queue.add(w);
        visited[w] = true;
        }
    }
  }
}
```

* 复杂度 O(V + E)
* 可以用于求最短路径

# BFS 和 DFS 的比较

本质上 BFS 和 DFS 在非递归实现上仅仅是存储容器的改变

```shell
visited[0...V-1] = false;

for (int v = 0; v < V; v++) {
  if (!visited[v])
    search(v);
}

search(int s) {
  x.add(s)
  visited[s] = true;
  while(!x.isEmpty()) {
    int v = x.remove();
    
    for (int w : G.adj(v)) {
      if (!visited[w]) {
        x.add(w);
        visited[w] = true;
        }
    }
  }
}
```
