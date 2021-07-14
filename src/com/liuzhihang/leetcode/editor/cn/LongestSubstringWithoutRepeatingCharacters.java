//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5042 👎 0


package com.liuzhihang.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            if (s.length() == 0) {
                return 0;
            }

            if (s.length() == 1) {
                return 1;
            }

            int length = 0;

            int leftIndex = 0;
            int rightIndex = 1;

            Set<Character> set = new HashSet<>();

            set.add(s.charAt(0));

            while (rightIndex < s.length()) {
                if (set.contains(s.charAt(rightIndex))) {
                    if (rightIndex - leftIndex > length) {
                        length = rightIndex - leftIndex;
                    }
                    set.remove(s.charAt(leftIndex++));
                } else {
                    set.add(s.charAt(rightIndex++));
                }
            }
            if (set.size() > length) {
                length = set.size();
            }

            return length;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
