//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 543 👎 0


package cn;

import java.util.*;

/**
 * @author cloaks
 * @questionId 752
 * @title 打开转盘锁
 * @titleSlug open-the-lock
 * @date 2022-09-06 21:18:21
 */
public class Code752OpenTheLock {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code752OpenTheLock().new Solution();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(solution.openLock(deadends, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private HashSet<String> deadSet = new HashSet<>();

        public int openLock(String[] deadends, String target) {
            for (String item : deadends) deadSet.add(item);

            if (deadSet.contains(target)) return -1;
            if (deadSet.contains("0000")) return -1;
            if (target.equals("0000")) return 0;

            // BFS
            Queue<String> queue = new LinkedList<>();
            HashMap<String, Integer> visited = new HashMap<>();

            queue.add("0000");
            visited.put("0000", 0);

            while (!queue.isEmpty()) {
                String currentPoint = queue.remove();
                ArrayList<String> nexts = new ArrayList<>();
                // todo move keyword start
                char[] current2chars = currentPoint.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char original = current2chars[i];
                    // 向后拨一位
                    current2chars[i] = Character.forDigit((current2chars[i] - '0' + 1) % 10, 10);
                    nexts.add(new String(current2chars));
                    current2chars[i] = original;
                    // 向前拨一位
                    current2chars[i] = Character.forDigit((current2chars[i] - '0' + 9) % 10, 10);
                    nexts.add(new String(current2chars));
                    current2chars[i] = original;
                }
                // todo keyword end
                for (String next : nexts)
                    if (!deadSet.contains(next) && !visited.containsKey(next)) {
                        queue.add(next);
                        visited.put(next, visited.get(currentPoint) + 1);
                        if (next.equals(target))
                            return visited.get(next);
                    }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

