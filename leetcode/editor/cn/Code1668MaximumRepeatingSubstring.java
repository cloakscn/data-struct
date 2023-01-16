//给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
// k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 
//为 0 。 
//
// 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。 
//
// 
//
// 示例 1： 
//
// 
//输入：sequence = "ababc", word = "ab"
//输出：2
//解释："abab" 是 "ababc" 的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：sequence = "ababc", word = "ba"
//输出：1
//解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
// 
//
// 示例 3： 
//
// 
//输入：sequence = "ababc", word = "ac"
//输出：0
//解释："ac" 不是 "ababc" 的子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sequence.length <= 100 
// 1 <= word.length <= 100 
// sequence 和 word 都只包含小写英文字母。 
// 
//
// Related Topics 字符串 字符串匹配 👍 137 👎 0


package cn;

/**
 * @author cloaks
 * @questionId 1668
 * @title 最大重复子字符串
 * @titleSlug maximum-repeating-substring
 * @date 2022-11-08 17:10:33
 */
public class Code1668MaximumRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code1668MaximumRepeatingSubstring().new Solution();
        System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba",
                "aaaba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            if (sequence == "" || word == "") return 0;
            if (sequence.length() < word.length()) return 0;

            int result = 0;
            boolean flag;
            int i = 0, j;
            int start = i;
            while (i < sequence.length()) {
                j = 0;
                flag = true;
                start = i + 1;

                while (j < word.length()) {
                    if (sequence.charAt(i) == word.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        if (i + 1 != sequence.length()) {
                            i = start;
                            result = 0;
                        } else {
                            i++;
                        }
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

