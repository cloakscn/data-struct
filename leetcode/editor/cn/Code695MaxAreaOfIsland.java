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
        private int col, row, x, y, size, max;
        private int[][] grid;

        public int maxAreaOfIsland(int[][] grid) {
            /**
             * 1. 二维转一维
             * 2. 四联通
             */
            if (grid == null) return 0;

            row = grid.length;
            if (row == 0) return 0;
            col = grid[0].length;
            if (col == 0) return 0;
            this.grid = grid;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 0) continue;
                    else if (grid[i][j] == -1) continue;
                    dfs(i, j);
                    if (size > max) {
                        max = size;
                    }
                    size = 0;
                }
            }
            return max;
        }

        private boolean nextPoint(int x, int y, String direction) {
            int nextX = 0, nextY = 0;
            switch (direction) {
                case "top":
                    nextX = x - 1;
                    nextY = y;
                    break;
                case "bottom":
                    nextX = x + 1;
                    nextY = y;
                    break;
                case "left":
                    nextX = x;
                    nextY = y - 1;
                    break;
                case "right":
                    nextX = x;
                    nextY = y + 1;
                    break;
            }
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                return false;
            }
            this.x = nextX;
            this.y = nextY;
            return true;
        }

        private void dfs(int x, int y) {
            size++;
            grid[x][y] = -1;

            if (nextPoint(x, y, "top") && grid[this.x][this.y] == 1)
                dfs(this.x, this.y);

            if (nextPoint(x, y, "bottom") && grid[this.x][this.y] == 1)
                dfs(this.x, this.y);

            if (nextPoint(x, y, "left") && grid[this.x][this.y] == 1)
                dfs(this.x, this.y);

            if (nextPoint(x, y, "right") && grid[this.x][this.y] == 1)
                dfs(this.x, this.y);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


