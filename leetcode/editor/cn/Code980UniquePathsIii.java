//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 214 👎 0


package cn;

/**
 * @author cloaks
 * @questionId 980
 * @title 不同路径 III
 * @titleSlug unique-paths-iii
 * @date 2022-09-27 22:50:27
 */
public class Code980UniquePathsIii {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code980UniquePathsIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] grid;
        private int row, col, start, end;
        private boolean[][] visited;
        private int[][] directions = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        public int uniquePathsIII(int[][] grid) {
            this.grid = grid;
            this.row = grid.length;
            this.col = grid[0].length;
            visited = new boolean[row][col];
            int left = row * col;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        start = i * col + j;
                        grid[i][j] = 0;
                    }
                    if (grid[i][j] == 2) {
                        end = i * col + j;
                        grid[i][j] = 0;
                    }
                    if (grid[i][j] == -1) {
                        left--;
                    }
                }
            }
            return dfs(start, left);
        }

        private int dfs(int v, int left) {
            int x = v / col, y = v % col;
            visited[x][y] = true;
            left--;
            if (left == 0 && v == end) {
                visited[x][y] = false;
                return 1;
            }
            int result = 0;
            for (int d = 0; d < 4; d++) {
                int nextX = x + directions[d][0], nextY = y + directions[d][1];
                if (inArea(nextX, nextY) && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    result += dfs(nextX * col + nextY, left);
                }
            }

            visited[x][y] = false;
            return result;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < col;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

