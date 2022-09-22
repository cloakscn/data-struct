//给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 
//pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。 
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [15,88], pieces = [[88],[15]]
//输出：true
//解释：依次连接 [15] 和 [88]
// 
//
// 示例 2： 
//
// 
//输入：arr = [49,18,16], pieces = [[16,18,49]]
//输出：false
//解释：即便数字相符，也不能重新排列 pieces[0]
// 
//
// 示例 3： 
//
// 
//输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//输出：true
//解释：依次连接 [91]、[4,64] 和 [78] 
//
// 
//
// 提示： 
//
// 
// 1 <= pieces.length <= arr.length <= 100 
// sum(pieces[i].length) == arr.length 
// 1 <= pieces[i].length <= arr.length 
// 1 <= arr[i], pieces[i][j] <= 100 
// arr 中的整数 互不相同 
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同） 
// 
//
// Related Topics 数组 哈希表 👍 92 👎 0


package cn;

import java.util.HashMap;

/**
 * @author cloaks
 * @questionId 1640
 * @title 能否连接形成数组
 * @titleSlug check-array-formation-through-concatenation
 * @date 2022-09-22 14:30:05
 */
public class Code1640CheckArrayFormationThroughConcatenation {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code1640CheckArrayFormationThroughConcatenation().new Solution();
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {
                {78},
                {4, 64},
                {91}
        };
        System.out.println(solution.canFormArray(arr, pieces));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private HashMap<Integer, int[]> hashMap = new HashMap<>();
        private int[] arr;

        private int index = 0;

        public boolean canFormArray(int[] arr, int[][] pieces) {
            this.arr = arr;
            // todo init hashMap
            for (int i = 0; i < pieces.length; i++) {
                hashMap.put(pieces[i][0], pieces[i]);
            }
            // todo traverse arr
            for (; index < arr.length; index++) {
                if (hashMap.containsKey(arr[index])) {
                    int[] temps = hashMap.get(arr[index]);
                    if (temps.length >= 1 && !traverse(temps)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean traverse(int[] pieces) {
            for (int i = 0; i < pieces.length; i++, index++) {
                if (arr[index] != pieces[i]) {
                    return false;
                }
            }
            index--;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
