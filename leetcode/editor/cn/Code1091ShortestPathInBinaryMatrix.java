//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 218 👎 0


package cn;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cloaks
 * @questionId 1091
 * @title 二进制矩阵中的最短路径
 * @titleSlug shortest-path-in-binary-matrix
 * @date 2022-09-05 21:41:28
 */
public class Code1091ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code1091ShortestPathInBinaryMatrix().new Solution();
        int[][] grid1 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid1));
        int[][] grid2 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 八联通
         */
        private int[][] direction = {
                {-1, 0},    // 上
                {-1, 1},    // 右上
                {0, 1},     // 右
                {1, 1},     // 右下
                {1, 0},     // 下
                {1, -1},    // 左下
                {0, -1},    // 左
                {-1, -1},   // 左上
        };
        private int n;
        private int[][] grid;
        private boolean[][] visited;
        private int[][] distance;

        public int shortestPathBinaryMatrix(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            visited = new boolean[n][n];
            distance = new int[n][n];

            if (grid[0][0] == 1) return -1;
            if (n == 1) return 1;
            return bfs(0, 0);
        }

        /**
         * 广度优先遍历
         * @param x x
         * @param y y
         */
        private int bfs(int x, int y) {
            Queue<Integer> queue = new LinkedList<>();
            // todo 入队
            queue.add(x * n + y);
            visited[x][y] = true;
            distance[x][y] = 1;
            while (!queue.isEmpty()) {
                // todo 出队
                int currentPoint = queue.remove();
                int currentX = currentPoint / n, currentY = currentPoint % n;
                for (int d = 0; d < 8; d++) {
                    int nextX = currentX + direction[d][0];
                    int nextY = currentY + direction[d][1];
                    if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        // todo 入队
                        queue.add(nextX * n + nextY);
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[currentX][currentY] + 1;
                        if (nextX == n - 1 && nextY == n - 1) {
                            return distance[nextX][nextY];
                        }
                    }
                }
            }
            return -1;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

