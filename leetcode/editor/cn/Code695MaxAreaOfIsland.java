//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 842 👎 0


package cn;

import java.util.HashSet;

/**
 * @author cloaks
 * @questionId 695
 * @title 岛屿的最大面积
 * @titleSlug max-area-of-island
 * @date 2022-09-04 21:20:54
 */
public class Code695MaxAreaOfIsland {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code695MaxAreaOfIsland().new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int col, row;

        // 四联通
        private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private int[][] grid;
        private boolean[] visited;
        private HashSet<Integer>[] G;

        /**
         * 1. 二维转一维
         * 2. 四联通
         */
        public int maxAreaOfIsland(int[][] grid) {

            if (grid == null) return 0;
            row = grid.length;
            if (row == 0) return 0;
            col = grid[0].length;
            if (col == 0) return 0;
            this.grid = grid;
            
            G = constructGraph();

            int result = 0;
            visited = new boolean[G.length];
            for (int v = 0; v < visited.length; v++) {
                // todo one dimensional 2 two dimensional
                int x = v / col, y = v % col;
                if (!visited[v] && grid[x][y] == 1) {
                    result = Math.max(result, dfs(v));
                }
            }
            return result;
        }

        /**
         * constructGraph
         * @return Graph Implement By HashSet
         */
        private HashSet<Integer>[] constructGraph() {
            HashSet<Integer>[] g = new HashSet[row * col];
            for (int i = 0; i < g.length; i++) {
                g[i] = new HashSet<>();
            }

            for (int v = 0; v < g.length; v++) {
                int x = v / col, y = v % col;
                if (grid[x][y] == 1) {
                    for (int d = 0; d < 4; d++) {
                        // todo point direction ↑ ↓ ← →
                        int nextX = x + directions[d][0];
                        int nextY = y + directions[d][1];
                        if (inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
                            // todo twoDimensional2oneDimensional
                            int next = nextX * col + nextY;
                            g[v].add(next);
                            g[next].add(v);
                        }
                    }
                }
            }
            return g;
        }

        /**
         * 坐标合法性校验
         * @param nextX x
         * @param nextY y
         * @return inArea true notInArea false
         */
        private boolean inArea(int nextX, int nextY) {
            return nextX >= 0 && nextX < row && nextY >= 0 && nextY < col;
        }

        /**
         * 图的深度优先遍历
         * @param v 图的顶点
         * @return 返回顶点 v 联通分量的数量
         */
        private int dfs(int v) {
            int result = 1;
            visited[v] = true;

            for (int w : G[v]) {
                if (!visited[w]) {
                    result += dfs(w);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


