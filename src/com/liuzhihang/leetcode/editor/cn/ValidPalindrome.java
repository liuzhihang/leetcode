//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 396 👎 0


package com.liuzhihang.leetcode.editor.cn;

public class ValidPalindrome {

    public static void main(String[] args) {

        // Solution solution = new ValidPalindrome().new Solution();

        System.out.println('A' - 'a');

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {

            if (s == null || s.length() == 0) {
                return true;
            }

            int left = 0;
            int right = s.length() - 1;

            // a-z：97-122
            // A-Z：65-90
            // 0-9：48-57

            while (left < right) {

                int leftCharConvert = convertChar(s.charAt(left));

                if (leftCharConvert == -1) {
                    left++;
                    continue;
                }
                int rightCharConvert = convertChar(s.charAt(right));
                if (rightCharConvert == -1) {
                    right--;
                    continue;
                }
                if (leftCharConvert != rightCharConvert) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }

        private int convertChar(char c) {

            // a-z：97-122
            // A-Z：65-90
            // 0-9：48-57

            if (c >= 65 && c <= 90) {
                return c + 32;
            }

            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                return c;
            }

            return -1;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
