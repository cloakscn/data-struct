//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3739 👎 0


package cn;

/**
 * @author cloaks
 * @questionId 7
 * @title 整数反转
 * @titleSlug reverse-integer
 * @date 2023-01-16 19:56:40
 */
public class Code7ReverseInteger {
    public static void main(String[] args) {
        System.out.println("hello world!");
        Solution solution = new Code7ReverseInteger().new Solution();
        System.out.println(solution.reverse(1534236469));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            String x1 = String.valueOf(x);
            StringBuffer sb = new StringBuffer();
            if (x1.charAt(0) == '-') {
                sb.append('-');
                for (int i = x1.length() - 1; i > 0; i--) {
                    sb.append(x1.charAt(i));
                }
            } else {
                for (int i = x1.length() - 1; i >= 0; i--) {
                    sb.append(x1.charAt(i));
                }
            }

            Integer integer;
            try {
                integer = Integer.valueOf(sb.toString());
            } catch (Exception e) {
                return 0;
            }
            return integer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
