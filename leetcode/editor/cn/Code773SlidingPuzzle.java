//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（
//上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 示例 2: 
//
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 示例 3: 
//
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//
// 提示： 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// board[i][j] 中每个值都 不同 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 277 👎 0


package cn;

import java.util.*;

/**
 * @author cloaks
 * @questionId 773
 * @title 滑动谜题
 * @titleSlug sliding-puzzle
 * @date 2022-09-08 22:48:40
 */
public class Code773SlidingPuzzle {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code773SlidingPuzzle().new Solution();
        int[][] board = {
                {1, 2, 3},
                {4, 5, 0}
        };
        System.out.println(solution.slidingPuzzle(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] direction = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        public int slidingPuzzle(int[][] board) {
            Map<String, Integer> visited = new HashMap();
            Queue<String> queue = new LinkedList<>();

            String initialState = board2String(board);
            if (initialState.equals("123450")) return 0;

            // todo BFS
            queue.offer(initialState);
            visited.put(initialState, 0);

            while (!queue.isEmpty()) {
                String current = queue.poll();
                // todo next
                ArrayList<String> nexts = getNexts(current);

                for (String next : nexts) {
                    if (!visited.containsKey(next)) {
                        queue.offer(next);
                        visited.put(next, visited.get(current) + 1);

                        // todo return
                        if (next.equals("123450")) return visited.get(next);
                    }
                }
            }
            return -1;
        }

        /**
         * 获取可以移动的方案列表
         * @param s 当前状态
         * @return
         */
        private ArrayList<String> getNexts(String s) {
            int[][] current = string2board(s);
            int zero;
            for (zero = 0; zero < 6; zero++) {
                if (current[zero / 3][zero % 3] == 0) {
                    break;
                }
            }

            ArrayList<String> result = new ArrayList<>();
            int zx = zero / 3, zy = zero % 3;
            // todo 四联通找方向
            for (int d = 0; d < 4; d++) {
                int nextX = zx + direction[d][0];
                int nextY = zy + direction[d][1];
                if (inArea(nextX, nextY)) {
                    swap(current, zx, zy, nextX, nextY);
                    result.add(board2String(current));
                    swap(current, nextX, nextY, zx, zy);
                }
            }
            return result;
        }

        private void swap(int[][] current, int zx, int zy, int nextX, int nextY) {
            current[zx][zy] += current[nextX][nextY];
            current[nextX][nextY] = current[zx][zy] - current[nextX][nextY];
            current[zx][zy] -= current[nextX][nextY];
        }

        private boolean inArea(int x, int y) {
            if (x >= 0 && x < 2 && y >= 0 && y < 3) return true;
            return false;
        }

        private int[][] string2board(String s) {
            int[][] board = new int[2][3];
            /**
             * x,y
             * x * 3 + y = i
             *
             * x = i / 3
             * y = i % 3
             */
            for (int i = 0; i < 6; i++) {
                board[i / 3][i % 3] = s.charAt(i) - '0';
            }
            return board;
        }

        private String board2String(int[][] board) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

