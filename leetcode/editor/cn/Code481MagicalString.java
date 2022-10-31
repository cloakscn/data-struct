//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 127 👎 0


package cn;

/**
 * @author cloaks
 * @questionId 481
 * @title 神奇字符串
 * @titleSlug magical-string
 * @date 2022-10-31 14:48:22
 */
public class Code481MagicalString {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code481MagicalString().new Solution();
        System.out.println(solution.magicalString(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int magicalString(int n) {
            if (n < 4) return 1;
            char[] s = new char[n];
            s[0] = '1';
            s[1] = '2';
            s[2] = '2';

            int result = 1;
            int i = 2;
            int j = 3;
            while (j < n) {
                int count = s[i++] == '2' ? 2 : 1;
                char last = s[j - 1] == '2' ? '1' : '2';
                while (count-- > 0) {
                    if (j >= n) {
                        break;
                    }
                    s[j++] = last;
                    if (last == '1') {
                        result++;
                    }
                }
            }

            return result;
        }

        public int magicalString_solution_01(int n) {
            StringBuffer s = new StringBuffer("12");
            StringBuffer s_copy = new StringBuffer();
            int result = 0;
            char append = '1';

            for (int i = 0; i < n; i++) {
                char c;
                if (i < 2) {
                    c = s.charAt(i);
                } else {
                    c = s_copy.charAt(i);
                }
                if (c == '1') {
                    for (int j = 0; j < 1; j++) s_copy.append(append);
                    result++;
                } else {
                    for (int j = 0; j < 2; j++) s_copy.append(append);
                }
                append = append == '1' ? '2' : '1';
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

