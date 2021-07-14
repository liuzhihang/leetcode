//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 304 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {

            int topChar = 0;

            // 存储当前区间每个字母出现的次数
            int[] charArr = new int[26];

            int left = 0;
            int right = 0;

            int sLength = s.length();

            while (right < sLength) {

                char cr = s.charAt(right);
                charArr[cr - 'A']++;

                // 出现次数最多的字母更新
                topChar = Math.max(topChar, charArr[cr - 'A']);

                if (right - left - topChar >= k) {
                    char cl = s.charAt(left);
                    charArr[cl - 'A']--;
                    left++;
                }
                right++;

            }


            return right - left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
