//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 309 👎 0


package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cloaks
 * @questionId 68
 * @title 文本左右对齐
 * @titleSlug text-justification
 * @date 2022-11-01 14:15:05
 */
public class Code68TextJustification {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code68TextJustification().new Solution();
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(solution.fullJustify(words, 16));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            List<String> line = new ArrayList<>();

            int lineSize = 0;
            // 遍历 words 列表，如果符合 maxWidth 的长度，就开始计算布局，如果不符合就继续
            for (int i = 0; i < words.length; i++) {
                line.add(words[i]);
                lineSize += words[i].length();
                if (i + 1 == words.length) {
                    // 说明当前是最后一个单词，可以对最后一行做特殊处理
                    StringBuffer curr = new StringBuffer();
                    int free = maxWidth - (lineSize + line.size() - 1);
                    for (int j = 0; j < line.size(); j++) {
                        if (j == line.size() - 1) {
                            curr.append(line.get(j) + getBlank(free));
                        } else {
                            curr.append(line.get(j) + " ");
                        }
                    }
                    result.add(curr.toString());
                }
                // 每个单词默认加一个空格
                if (i < words.length - 1 && (lineSize + line.size() - 1 < maxWidth && lineSize + words[i + 1].length() + line.size() > maxWidth)) {
                    // 如果加上下一个单词的长度超过了最大限制，就只对当前单词进行计算，并清空当前行的字符串，如果没有就继续
                    // 每个单词加一个空格，长度为 单词长度 + 单词个数 - 1，剩余长度平均分配到每个单词中间
                    List<String> curr = new ArrayList<>();

                    int free = 0;
                    String avgBlank = "";
                    if (line.size() > 1) {
                        free = maxWidth - (lineSize + line.size() - 1);
                        avgBlank = line.size() > 1 ? getBlank(free / (line.size() - 1)) : "";
                        free = free % (line.size() - 1);
                        for (int j = 0; j < line.size(); j++) {
                            if (j == 0) {
                                curr.add(line.get(j) + " " + getBlank(free));
                            } else if (j == line.size() - 1) {
                                curr.add(line.get(j));
                            } else {
                                curr.add(line.get(j) + " ");
                            }
                        }
                    } else {
                        free = maxWidth - lineSize;
                        for (int j = 0; j < line.size(); j++) {
                            curr.add(line.get(j) + getBlank(free));
                        }
                    }

                    result.add(String.join(avgBlank, curr));
                    line.clear();
                    lineSize = 0;
                }
            }
            return result;
        }

        private String getBlank(int count) {
            String result = "";
            for (int i = 0; i < count; i++) {
                result += " ";
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

