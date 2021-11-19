//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4315 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubstring().new Solution();

    }
    // class Solution {
    //     public String longestPalindrome(String s) {
    //
    //         // 中心扩散
    //         if (s == null || s.length() == 1) {
    //             return s;
    //         }
    //
    //         int strLength = s.length();
    //
    //         int resStartIndex = 0;
    //         int resLength = 0;
    //
    //         int len = 1;
    //         int left;
    //         int right;
    //         // 遍历字符串
    //         for (int i = 0; i < strLength; i++) {
    //             left = i;
    //             right = i;
    //             char ci = s.charAt(i);
    //
    //             // 左边相同字符
    //             while (left >= 1 && s.charAt(left - 1) == ci) {
    //                 left--;
    //                 len++;
    //             }
    //
    //             // 右边相同字符
    //             while (right <= strLength - 2 && s.charAt(right + 1) == ci) {
    //                 right++;
    //                 len++;
    //             }
    //             // 两边扩散, 相同
    //             while (left >= 1 && right <= strLength - 2 && s.charAt(left - 1) == s.charAt(right + 1)) {
    //                 left--;
    //                 right++;
    //                 len = len + 2;
    //             }
    //             if (len > resLength) {
    //                 resLength = len;
    //                 resStartIndex = left;
    //             }
    //             len = 1;
    //
    //         }
    //
    //         return s.substring(resStartIndex, resStartIndex + resLength);
    //
    //     }
    //
    // }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划
         * <p>
         * dp[i][j] 表示 s[i]...s[j] 是否回文,如果回文,则 s[i]==s[j] 且 dp[i-1][j-1] 回文
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            // 特殊用例判断
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;

            boolean[][] dp = new boolean[len][len];
            char[] charArray = s.toCharArray();

            // 对角线,单字符 都是回文 true
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            for (int j = 1; j < len; j++) {

                for (int i = 0; i < j; i++) {
                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}
