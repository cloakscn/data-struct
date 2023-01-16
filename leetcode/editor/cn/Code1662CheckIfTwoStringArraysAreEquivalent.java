//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10³ 
// 1 <= word1[i].length, word2[i].length <= 10³ 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
// word1[i] 和 word2[i] 由小写字母组成 
// 
//
// Related Topics 数组 字符串 👍 49 👎 0


package cn;

/**
 * @author cloaks
 * @questionId 1662
 * @title 检查两个字符串数组是否相等
 * @titleSlug check-if-two-string-arrays-are-equivalent
 * @date 2022-11-01 11:55:56
 */
public class Code1662CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code1662CheckIfTwoStringArraysAreEquivalent().new Solution();
        String[] word1 = new String[] { "ab","c"};
        String[] word2 = new String[] { "abc"};
        System.out.println(solution.arrayStringsAreEqual(word1, word2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int point1 = 0, point2 = 0;
            int index1 = 0, index2 = 0;
            while (index1 < word1.length && index2 < word2.length) {
                if (word1[index1].charAt(point1++) != word2[index2].charAt(point2++)) {
                    return false;
                }
                if (point1 == word1[index1].length()) {
                    index1++;
                    point1 = 0;
                }
                if (point2 == word2[index2].length()) {
                    index2++;
                    point2 = 0;
                }
            }
            return index1 == word1.length && index2 == word2.length;
        }


        public boolean arrayStringsAreEqual_02(String[] word1, String[] word2) {
            return String.join("", word1).equals(String.join("", word2));
        }


        public boolean arrayStringsAreEqual_01(String[] word1, String[] word2) {
            int point1 = -1, point2 = -1;
            String curr1 = "", curr2 = "";
            int index1 = 0, index2 = 0;
            while (index1 <= word1.length || index2 <= word2.length) {
                // 选择下一个字符串数组
                if (point1 == -1 && index1 < word1.length) {
                    curr1 = word1[index1++];
                    point1 = 0;
                }
                if (point2 == -1 && index2 < word2.length) {
                    curr2 = word2[index2++];
                    point2 = 0;
                }

                // todo: 判断两边是否同时走完
                if (curr1 == "" && curr2 == "") break;

                // 判断是否相同
                if (curr1 == "" || curr2 == "" || curr1.charAt(point1++) != curr2.charAt(point2++)) {
                    return false;
                }

                // 判断指针是否已经等于字符串的长度，置空
                // todo: 避免出现一条线已经走完，但是另一条线还没走完，新值会和旧值比较
                if (point1 == curr1.length()) {
                    curr1 = "";
                    point1 = -1;
                }
                if (point2 == curr2.length()) {
                    curr2 = "";
                    point2 = -1;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

